package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 회원 정보를 일괄출력하는 Class
// Spring이 해당 Class를 검색해서 Bean으로 등록할 수 있음 (이름 지정)
@Component("listPrinter")
public class MemberListPrinter
{
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter()
	{
		// memberDao 객체가 자동주입되므로, 인스턴스 생성 시 memberDao를 주입하지 않아도 된다.
	}
	
	/*
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer)
	{
		this.memberDao = memberDao;
		this.printer = printer;
	}
	*/
	
	// MemberPrinter#print와 Collection을 이용하여 정보 일괄출력
	public void printAll()
	{
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
	
	// memberDao 객체 자동주입
	@Autowired
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	// printer 객체 자동주입
	@Autowired
	// 생성한 객체의 한정자를 summaryPrinter로 지정
	@Qualifier("summaryPrinter")
	public void setMemberPrinter(MemberPrinter printer)
	{
		this.printer = printer;
	}
}