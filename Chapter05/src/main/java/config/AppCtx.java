package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

// ===========================================================================
// @Bean�� ���� ��� getBean�� ���� ��ü�� ���� �� ����.
// @Bean���� ������ Method�� �̸��� getBean�� ������ �̸��� �ٸ� ��� ��������
// Spring�� @Bean�� ���� Method�� ���� �ϳ��� ��ü���� �����Ѵ�.
// ===========================================================================

// Spring Config Class
// @Component ó���� Class�� �˻��ؼ� Bean���� �߰���
@Configuration
@ComponentScan(basePackages =  {"spring"})
public class AppCtx
{
	// @Component ó���� Class���� �������Ͽ� ���� �ʿ䰡 ����
	
	// ������ ��ü�� memberPrinter1�̶�� Bean���� ����
	@Bean
	// ������ ��ü�� �����ڸ� printer�� ����
	@Qualifier("printer")
	public MemberPrinter memberPrinter1()
	{
		return new MemberPrinter();
	}
	
	// ������ ��ü�� memberPrinter2��� Bean���� ����
	@Bean
	// ������ ��ü�� �����ڸ� summaryPrinter�� ����
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter MemberPrinter2()
	{
		return new MemberSummaryPrinter();
	}
	
	// ������ ��ü�� versionPrinter��� Bean���� ����
	@Bean
	public VersionPrinter versionPrinter()
	{
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		
		return versionPrinter;
	}
}