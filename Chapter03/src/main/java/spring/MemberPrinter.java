package spring;

// ȸ�� ������ ��������ϴ� Class
public class MemberPrinter
{
	// ȸ�� ���� �ܼ� Colsole ���
	public void print(Member member)
	{
		System.out.printf("ȸ�� ���� : ���̵�=%d, �̸���=%s, �̸�=%s, �����=%tF\n", member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
	}
}