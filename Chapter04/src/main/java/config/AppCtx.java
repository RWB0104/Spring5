package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class AppCtx
{
	// ������ ��ü�� memberDao��� Bean���� ����
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	
	// ������ ��ü�� MemberRegSvc��� Bean���� ����
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService();
		
		// �ش� Class�� memberDao�� @Autowired�� �������Ƿ� �ش� ��ü�� �ڵ������� �ȴ�.
		// return new MemberRegisterService(memberDao());
	}
	
	// ������ ��ü�� changePwdSvc��� Bean���� ����
	@Bean
	public ChangePasswordService changePwdSvc()
	{
		ChangePasswordService pwdSvc = new ChangePasswordService();
		
		// �ش� Class�� memberDao�� @Autowired�� �������Ƿ� �ش� ��ü�� �ڵ������� �ȴ�.
		// pwdSvc.setMemberDao(memberDao());
		
		return pwdSvc;
	}
	
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
	
	// ������ ��ü�� listPrinter��� Bean���� ����
	@Bean
	public MemberListPrinter listPrinter()
	{
		return new MemberListPrinter();
		
		// �ش� Class�� memberDao, memberPrinter�� @Autowired�� �������Ƿ� �ش� ��ü�� �ڵ������� �ȴ�.
		// return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	// ������ ��ü�� infoPrinter��� Bean���� ����
	@Bean
	//@Qualifier("printer")
	public MemberInfoPrinter infoPrinter()
	{
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(MemberPrinter2());
		
		// �ش� Class�� memberPrinter�� @Autowired�� �������Ƿ� �ش� ��ü�� �ڵ������� �ȴ�.
		// infoPrinter.setPrinter(memberPrinter());
		
		return infoPrinter;
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