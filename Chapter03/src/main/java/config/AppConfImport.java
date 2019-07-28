package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberPrinter;

// ===========================================================================
// Import로 지정한 Class를 같이 사용함
// 아래의 경우, AppConf2를 이용했으므로, 해당 Class를 따로 지정할 필요 없음
// 쉼표 구분을 통한 다중 클래스 할당 가능
// ===========================================================================

@Configuration
@Import(AppConf2.class)
public class AppConfImport
{
	// 생성한 객체를 memberDao라는 Bean으로 지정
	@Bean
	public MemberDao memberDao()
	{
		return new MemberDao();
	}
	
	// 생성한 객체를 memberPrinter라는 Bean으로 지정
	@Bean
	public MemberPrinter memberPrinter()
	{
		return new MemberPrinter();
	}
}