package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberPrinter;

// ===========================================================================
// Import�� ������ Class�� ���� �����
// �Ʒ��� ���, AppConf2�� �̿������Ƿ�, �ش� Class�� ���� ������ �ʿ� ����
// ��ǥ ������ ���� ���� Ŭ���� �Ҵ� ����
// ===========================================================================

@Configuration
@Import(AppConf2.class)
public class AppConfImport
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