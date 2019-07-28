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
// @Autowired는 자동으로 Bean을 주입한다.
// ===========================================================================

@Configuration
public class AppConf2
{
	// 해당 타입의 Bean을 찾아 자동으로 주입
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	// 생성한 객체를 memberRegSvc라는 Bean으로 지정
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService(memberDao);
	}
	
	// 생성한 객체를 changePwdSvc라는 Bean으로 지정
	@Bean
	public ChangePasswordService changePwdSvc()
	{
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
		return pwdSvc;
	}
	
	// 생성한 객체를 listPrinter라는 Bean으로 지정
	@Bean
	public MemberListPrinter listPrinter()
	{
		return new MemberListPrinter(memberDao, memberPrinter);
	}
	
	// 생성한 객체를 infoPrinter라는 Bean으로 지정
	@Bean
	public MemberInfoPrinter infoPrinter()
	{
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(memberPrinter);
		
		return infoPrinter;
	}
	
	// 생성한 객체를 versionPrinter라는 Bean으로 지정
	@Bean
	public VersionPrinter versionPrinter()
	{
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		
		return versionPrinter;
	}
}