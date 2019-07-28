package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// 지정한 Email을 가진 회원의 정보를 출력하는 Class
public class MemberInfoPrinter
{
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email)
	{
		// DB에서 해당 Email을 가진 member 찾기
		Member member = memberDao.selectByEmail(email);
		
		// member 객체가 null일 경우
		if (member == null)
		{
			System.out.println("데이터 없음\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
	// Setter를 통한 MemberDao 주입
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	// Setter를 통한 MemberPrinter 주입 (Autowired를 이용한 자동주입화)
	@Autowired
	// 생성한 객체의 한정자를 printer로 지정
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer)
	{
		this.printer = printer;
	}
}