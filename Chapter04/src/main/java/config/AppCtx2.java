package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import spring.MemberInfoPrinter2;
import spring.MemberPrinter;

public class AppCtx2
{
	// 생성한 객체를 printer라는 Bean으로 지정
	@Bean
	public MemberPrinter printer()
	{
		return new MemberPrinter();
	}
	
	// 생성한 객체를 printer2라는 Bean으로 지정
	@Bean
	// 생성한 객체의 한정자를 mprinter로 지정
	@Qualifier("mprinter")
	public MemberPrinter printer2()
	{
		return new MemberPrinter();
	}
	
	// 생성한 객체를 infoPrinter라는 Bean으로 지정
	@Bean
	public MemberInfoPrinter2 infoPrinter()
	{
		MemberInfoPrinter2 infoPrinter = new MemberInfoPrinter2();
		
		return infoPrinter;
	}
}