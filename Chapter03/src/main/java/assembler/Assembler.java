package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

// ������ ��ü�� �����ϴ� Class
public class Assembler
{
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler()
	{
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
		
		// ���� Cache�� ����� DB�� ������ ���, �� ���� �ϳ��� �����ϸ� �ȴ�.
		// this.memberDao = new CachedMemberDao();
	}
	
	// Member ������ ���� (DB)
	public MemberDao getMemberDao()
	{
		return memberDao;
	}
	
	// ȸ������ ���� ����
	public MemberRegisterService getMemberRegisterService()
	{
		return regSvc;
	}
	
	// ��ȣ ���� ���� ����
	public ChangePasswordService getChangePasswordService()
	{
		return pwdSvc;
	}
}