package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

// 회원가입을 진행하는 Class
public class MemberRegisterService
{
	//memberDao 객체 자동주입
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService()
	{
		// memberDao 객체가 자동주입되므로, 인스턴스 생성 시 memberDao를 주입하지 않아도 된다.
	}
	
	/*
	public MemberRegisterService(MemberDao memberDao)
	{
		this.memberDao = memberDao;
		
		// 만약 Cache가 적용된 DB로 변경할 경우, 이 구문 하나만 변경하면 된다.
		// this.memberDao = CachedMemberDao();
	}
	*/
	
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