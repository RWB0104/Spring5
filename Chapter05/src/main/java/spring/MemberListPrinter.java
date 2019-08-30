package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// ȸ�� ������ �ϰ�����ϴ� Class
// Spring�� �ش� Class�� �˻��ؼ� Bean���� ����� �� ���� (�̸� ����)
@Component("listPrinter")
public class MemberListPrinter
{
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter()
	{
		// memberDao ��ü�� �ڵ����ԵǹǷ�, �ν��Ͻ� ���� �� memberDao�� �������� �ʾƵ� �ȴ�.
	}
	
	/*
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer)
	{
		this.memberDao = memberDao;
		this.printer = printer;
	}
	*/
	
	// MemberPrinter#print�� Collection�� �̿��Ͽ� ���� �ϰ����
	public void printAll()
	{
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
	
	// memberDao ��ü �ڵ�����
	@Autowired
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	// printer ��ü �ڵ�����
	@Autowired
	// ������ ��ü�� �����ڸ� summaryPrinter�� ����
	@Qualifier("summaryPrinter")
	public void setMemberPrinter(MemberPrinter printer)
	{
		this.printer = printer;
	}
}