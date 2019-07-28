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
// @Bean이 없을 경우 getBean을 통해 객체를 구할 수 없다.
// @Bean으로 지정된 Method의 이름과 getBean에 대입한 이름이 다를 경우 마찬가지
// Spring은 @Bean이 붙은 Method에 대해 하나의 객체만을 생성한다.
// ===========================================================================

// Spring Config Class
@Configuration
public class AppCtx
{
	// 생성한 객체를 memberDao라는 Bean으로 지정
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	
	// 생성한 객체를 MemberRegSvc라는 Bean으로 지정
	@Bean
	public MemberRegisterService memberRegSvc()
	{
		return new MemberRegisterService();
		
		// 해당 Class의 memberDao에 @Autowired가 쓰였으므로 해당 객체가 자동주입이 된다.
		// return new MemberRegisterService(memberDao());
	}
	
	// 생성한 객체를 changePwdSvc라는 Bean으로 지정
	@Bean
	public ChangePasswordService changePwdSvc()
	{
		ChangePasswordService pwdSvc = new ChangePasswordService();
		
		// 해당 Class의 memberDao에 @Autowired가 쓰였으므로 해당 객체가 자동주입이 된다.
		// pwdSvc.setMemberDao(memberDao());
		
		return pwdSvc;
	}
	
	// 생성한 객체를 memberPrinter1이라는 Bean으로 지정
	@Bean
	// 생성한 객체의 한정자를 printer로 지정
	@Qualifier("printer")
	public MemberPrinter memberPrinter1()
	{
		return new MemberPrinter();
	}
	
	// 생성한 객체를 memberPrinter2라는 Bean으로 지정
	@Bean
	// 생성한 객체의 한정자를 summaryPrinter로 지정
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter MemberPrinter2()
	{
		return new MemberSummaryPrinter();
	}
	
	// 생성한 객체를 listPrinter라는 Bean으로 지정
	@Bean
	public MemberListPrinter listPrinter()
	{
		return new MemberListPrinter();
		
		// 해당 Class의 memberDao, memberPrinter에 @Autowired가 쓰였으므로 해당 객체가 자동주입이 된다.
		// return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	// 생성한 객체를 infoPrinter라는 Bean으로 지정
	@Bean
	//@Qualifier("printer")
	public MemberInfoPrinter infoPrinter()
	{
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setPrinter(MemberPrinter2());
		
		// 해당 Class의 memberPrinter에 @Autowired가 쓰였으므로 해당 객체가 자동주입이 된다.
		// infoPrinter.setPrinter(memberPrinter());
		
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