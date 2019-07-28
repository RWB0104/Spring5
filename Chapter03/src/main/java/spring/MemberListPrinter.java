package spring;

import java.util.Collection;

// ȸ�� ������ �ϰ�����ϴ� Class
public class MemberListPrinter
{
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer)
	{
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	// MemberPrinter#print�� Collection�� �̿��Ͽ� ���� �ϰ����
	public void printAll()
	{
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
}