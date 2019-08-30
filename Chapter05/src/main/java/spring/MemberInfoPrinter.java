package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// ������ Email�� ���� ȸ���� ������ ����ϴ� Class
// Spring�� �ش� Class�� �˻��ؼ� Bean���� ����� �� ���� (�̸� ����)
@Component("infoPrinter")
public class MemberInfoPrinter
{
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email)
	{
		// DB���� �ش� Email�� ���� member ã��
		Member member = memberDao.selectByEmail(email);
		
		// member ��ü�� null�� ���
		if (member == null)
		{
			System.out.println("������ ����\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
	// Setter�� ���� MemberDao ����
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	
	// Setter�� ���� MemberPrinter ���� (Autowired�� �̿��� �ڵ�����ȭ)
	@Autowired
	// ������ ��ü�� �����ڸ� printer�� ����
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer)
	{
		this.printer = printer;
	}
}