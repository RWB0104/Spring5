package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 해당 Class를 Spring Configuration Class로 지정
@Configuration
public class AppContext
{
	// 해당 Method가 생성한 객체를 Spring이 관리하는 빈 객체로 등록
	@Bean
	public Greeter greeter()
	{
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		
		return g;
	}
	
	// 생성되는 객체 추가
	@Bean
	public Greeter greeter1()
	{
		Greeter g = new Greeter();
		g.setFormat("안녕하세요, %s님!");
		return g;
	}
}