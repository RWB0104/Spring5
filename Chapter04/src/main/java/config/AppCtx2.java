package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import spring.MemberInfoPrinter2;
import spring.MemberPrinter;

public class AppCtx2
{
	// ������ ��ü�� printer��� Bean���� ����
	@Bean
	public MemberPrinter printer()
	{
		return new MemberPrinter();
	}
	
	// ������ ��ü�� printer2��� Bean���� ����
	@Bean
	// ������ ��ü�� �����ڸ� mprinter�� ����
	@Qualifier("mprinter")
	public MemberPrinter printer2()
	{
		return new MemberPrinter();
	}
	
	// ������ ��ü�� infoPrinter��� Bean���� ����
	@Bean
	public MemberInfoPrinter2 infoPrinter()
	{
		MemberInfoPrinter2 infoPrinter = new MemberInfoPrinter2();
		
		return infoPrinter;
	}
}