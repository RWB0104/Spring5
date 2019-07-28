package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
public class AppConf1
{
	// ������ ��ü�� memberDao��� Bean���� ����
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	
	// ������ ��ü�� memberPrinter��� Bean���� ����
	@Bean
	public MemberPrinter memberPrinter()
	{
		return new MemberPrinter();
	}
}