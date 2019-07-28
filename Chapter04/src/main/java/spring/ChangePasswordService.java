package spring;

import org.springframework.beans.factory.annotation.Autowired;

// 암호 변경 기능 Class
public class ChangePasswordService
{
	//memberDao 객체 자동주입
	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd)
	{
		Member member = memberDao.selectByEmail(email);
		
		// member 객체가 null일 경우
		if (member == null)
		{
			// 예외 반환
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
		
		// 만약 Cache가 적용된 DB로 변경할 경우, 이 구문 하나만 변경하면 된다.
		// this.memberDao = CachedMemberDao();
	}
}