package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
public class AppConf1
{
	// 생성한 객체를 memberDao라는 Bean으로 지정
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	
	// 생성한 객체를 memberPrinter라는 Bean으로 지정
	@Bean
	public MemberPrinter memberPrinter()
	{
		return new MemberPrinter();
	}
}