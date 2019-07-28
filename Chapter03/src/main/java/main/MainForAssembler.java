package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.WrongIdPasswordException;

// 실제 프로그램의 동작 Class (Assembler 사용)
public class MainForAssembler
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 실제 동작
		while (true)
		{
			System.out.println("명령어를 입력하세요.");
			System.out.print(">> ");
			
			// 명령어 읽기
			String command = reader.readLine();
			
			// 종료
			if (command.startsWith("exit"))
			{
				System.out.println("종료합니다.\n");
				break;
			}
			
			// 회원가입
			if (command.startsWith("new "))
			{
				// 입력한 구문을 공백 기준으로 분할
				processNewCommand(command.split(" "));
				continue;
			}
			
			// 암호 변경
			else if (command.startsWith("change "))
			{
				// 입력한 구문을 공백 기준으로 분할
				processChangeCommand(command.split(" "));
				continue;
			}
			
			// 도움말
			printHelp();
		}
	}
	
	private static Assembler assembler = new Assembler();
	
	// 회원가입 프로세스
	private static void processNewCommand(String[] arg)
	{
		// 입력된 문자열 배열의 수가 5개가 아닐 경우
		if (arg.length != 5)
		{
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = assembler.getMemberRegisterService();
		RegisterRequest req = new RegisterRequest();
		
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		// 암호와 암호확인이 서로 일치하지 않을 경우
		if (!req.isPasswordEqualToConfirmPassword())
		{
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		
		// 회원 등록
		try
		{
			regSvc.regist(req);
			System.out.println("등록했습니다.\n");
		}
		
		// 등록하려는 이메일이 이미 있을 경우
		catch (DuplicateMemberException e)
		{
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
	
	// 암호 변경 프로세스
	private static void processChangeCommand(String[] arg)
	{
		// 입력된 문자열 배열의 수가 4개가 아닐 경우
		if (arg.length != 4)
		{
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
		
		// 암호 변경
		try
		{
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
		}
		
		// 입력한 이메일이 존재하지 않을 경우
		catch (MemberNotFoundException e)
		{
			System.out.println("존재하지 않는 이메일입니다.\n");
		}
		
		// 기존 암호가 일치하지 않을 경우
		catch (WrongIdPasswordException e)
		{
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
	}
	
	// 명령어 도움말
	private static void printHelp()
	{
		System.out.println();
		System.out.println("===================================");
		System.out.println("             명령어\n");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 변경암호");
		System.out.println("===================================\n");
	}
}