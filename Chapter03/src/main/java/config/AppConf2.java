package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

// ===========================================================================
// @Autowired�� �ڵ����� Bean�� �����Ѵ�.
// ===========================================================================

@Configuration
public class AppConf2
{
	// �ش� Ÿ���� Bean�� ã�� �ڵ����� ����
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	// ������ ��ü�� memberRegSvc��� Bean���� ����
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService(memberDao);
	}
	
	// ������ ��ü�� changePwdSvc��� Bean���� ����
	@Bean
	public ChangePasswordService changePwdSvc()
	{
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
		return pwdSvc;
	}
	
	// ������ ��ü�� listPrinter��� Bean���� ����
	@Bean
	public MemberListPrinter listPrinter()
	{
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	// ������ ��ü�� infoPrinter��� Bean���� ����
	@Bean
	public MemberInfoPrinter infoPrinter()
	{
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(memberPrinter);
		
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