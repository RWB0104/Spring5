package spring;

// ��ȣ ���� ��� Class
public class ChangePasswordService
{
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd)
	{
		Member member = memberDao.selectByEmail(email);
		
		// member ��ü�� null�� ���
		if (member == null)
		{
			// ���� ��ȯ
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
		
		// ���� Cache�� ����� DB�� ������ ���, �� ���� �ϳ��� �����ϸ� �ȴ�.
		// this.memberDao = CachedMemberDao();
	}
}