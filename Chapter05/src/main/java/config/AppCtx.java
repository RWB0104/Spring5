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
// @Bean이 없을 경우 getBean을 통해 객체를 구할 수 없다.
// @Bean으로 지정된 Method의 이름과 getBean에 대입한 이름이 다를 경우 마찬가지
// Spring은 @Bean이 붙은 Method에 대해 하나의 객체만을 생성한다.
// ===========================================================================

// Spring Config Class
// @Component 처리된 Class를 검색해서 Bean으로 추가함
@Configuration
@ComponentScan(basePackages =  {"spring"})
public class AppCtx
{
	// @Component 처리된 Class들은 설정파일에 있을 필요가 없음
	
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