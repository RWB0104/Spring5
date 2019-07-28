package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

// 실제로 객체를 생성하는 Class
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
		
		// 만약 Cache가 적용된 DB로 변경할 경우, 이 구문 하나만 변경하면 된다.
		// this.memberDao = new CachedMemberDao();
	}
	
	// Member 데이터 제공 (DB)
	public MemberDao getMemberDao()
	{
		return memberDao;
	}
	
	// 회원가입 서비스 제공
	public MemberRegisterService getMemberRegisterService()
	{
		return regSvc;
	}
	
	// 암호 변경 서비스 제공
	public ChangePasswordService getChangePasswordService()
	{
		return pwdSvc;
	}
}