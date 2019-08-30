package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 암호 변경 기능 Class
// Spring이 해당 Class를 검색해서 Bean으로 등록할 수 있음
@Component
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