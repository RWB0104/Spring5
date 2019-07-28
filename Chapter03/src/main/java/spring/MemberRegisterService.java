package spring;

import java.time.LocalDateTime;

// 회원가입을 진행하는 Class
public class MemberRegisterService
{
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao)
	{
		this.memberDao = memberDao;
		
		// 만약 Cache가 적용된 DB로 변경할 경우, 이 구문 하나만 변경하면 된다.
		// this.memberDao = CachedMemberDao();
	}
	
	// Account 생성
	public Long regist(RegisterRequest req)
	{
		Member member = memberDao.selectByEmail(req.getEmail());
		
		// member 객체가 null이 아닐 경우
		if (member != null)
		{
			// 예외 반환
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}