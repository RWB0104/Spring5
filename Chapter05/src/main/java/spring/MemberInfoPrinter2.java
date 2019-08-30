package spring;

import org.springframework.beans.factory.annotation.Autowired;

// 테스트용 Class
public class MemberInfoPrinter2
{
	@SuppressWarnings("unused")
	@Autowired
	private MemberPrinter printer;
}