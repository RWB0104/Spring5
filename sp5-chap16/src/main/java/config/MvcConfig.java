package config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import interceptor.AuthCheckInterceptor;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer
{
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		registry.jsp("/WEB-INF/view/", ".jsp");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/main").setViewName("main");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(authCheckInterceptor()).addPathPatterns("/edit/**").excludePathPatterns("/edit/help/**");
	}
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().featuresToEnable(SerializationFeature.INDENT_OUTPUT).deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(formatter)).simpleDateFormat("yyyyMMdd HHmmss").build();
		
		converters.add(0, new MappingJackson2HttpMessageConverter(objectMapper));
	}
	
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message.label");
		ms.setDefaultEncoding("UTF-8");
		
		return ms;
	}
	
	@Bean
	public AuthCheckInterceptor authCheckInterceptor()
	{
		return new AuthCheckInterceptor();
	}
}