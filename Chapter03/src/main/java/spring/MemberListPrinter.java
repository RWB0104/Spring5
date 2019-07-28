package spring;

import java.util.Collection;

// 회원 정보를 일괄출력하는 Class
public class MemberListPrinter
{
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer)
	{
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	// MemberPrinter#print와 Collection을 이용하여 정보 일괄출력
	public void printAll()
	{
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
}