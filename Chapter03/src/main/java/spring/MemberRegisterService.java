package spring;

import java.time.LocalDateTime;

// ȸ�������� �����ϴ� Class
public class MemberRegisterService
{
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao)
	{
		this.memberDao = memberDao;
		
		// ���� Cache�� ����� DB�� ������ ���, �� ���� �ϳ��� �����ϸ� �ȴ�.
		// this.memberDao = CachedMemberDao();
	}
	
	// Account ����
	public Long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		
		// member ��ü�� null�� �ƴ� ���
		if (member != null)
		{
			// ���� ��ȯ
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}