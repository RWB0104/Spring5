package spring;

import java.time.format.DateTimeFormatter;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.lang.Nullable;

// =====================================================================================
// @Autowired는 소스의 동작과 관계없이 매칭되는 Bean이 없을 경우 예외를 발생
// required 속성을 false로 지정하면 매칭되는 Bean이 없으면 객체 자동주입을 수행하지 않음
// Nullable은 Bean이 존재하지 않아도 Method가 호출됨
// repuired false 지정의 경우 Bean이 존재하지 않으면 Method가 호출되지 않음
// =====================================================================================

// 회원 정보를 단일출력하는 Class
public class MemberPrinter
{
	private DateTimeFormatter dateTimeFormatter;
	
	// 회원 정보 단순 Colsole 출력
	public void print(Member member)
	{
		if (dateTimeFormatter == null)
		{
			System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		}
		
		else
		{
			System.out.printf("회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
	// dateTimeFormatter 객체 자동주입 (필수 아님)
	@Autowired(required =  false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter)
	{
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
	// Optional 속성을 사용해도 required와 동일한 기능을 부여할 수 있음
	/*
	@Autowired
	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt)
	{
		// 일치하는 Bean이 있을 경우
		if (formatterOpt.isPresent())
		{
			this.dateTimeFormatter = formatterOpt.get();
		}
		
		// 일치하는 Bean이 없을 경우
		else
		{
			this.dateTimeFormatter = null;
		}
	}
	*/
	
	// Nullable 속성을 사용해도 required와 동일한 기능을 부여할 수 있음
	/*
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter)
	{
		this.dateTimeFormatter = dateTimeFormatter;
	}
	*/
}