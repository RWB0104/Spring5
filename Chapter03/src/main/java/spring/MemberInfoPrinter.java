package spring;

// ������ Email�� ���� ȸ���� ������ ����ϴ� Class
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
	
	// Setter�� ���� MemberPrinter ����
	public void setPrinter(MemberPrinter printer)
	{
		this.printer = printer;
	}
}