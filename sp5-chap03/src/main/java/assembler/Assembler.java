package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

public class Assembler
{
	private MemberDao memberDao;
	private MemberRegisterService regSvr;
	private ChangePasswordService pwdSvc;
	private MemberPrinter memberPrinter;
	private MemberListPrinter listPrinter;
	private MemberInfoPrinter infoPrinter;
	private VersionPrinter versionPrinter;
	
	public Assembler()
	{
		memberDao = new MemberDao();
		
		regSvr = new MemberRegisterService(memberDao);
		
		pwdSvc = new ChangePasswordService();
		
		pwdSvc.setMemberDao(memberDao);
		
		memberPrinter = new MemberPrinter();
		
		listPrinter = new MemberListPrinter(memberDao, memberPrinter);
		
		infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(memberPrinter);
		
		versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
	}
	
	public MemberDao getMemberDao()
	{
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService()
	{
		return regSvr;
	}
	
	public ChangePasswordService getChangePasswordService()
	{
		return pwdSvc;
	}
	
	public MemberPrinter getMemberPrinter()
	{
		return memberPrinter;
	}
	
	public MemberListPrinter getMemberListPrinter()
	{
		return listPrinter;
	}
	
	public MemberInfoPrinter getMemberInfoPrinter()
	{
		return infoPrinter;
	}
	
	public VersionPrinter getVersionPrinter()
	{
		return versionPrinter;
	}
}