package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongIdPasswordException;

//���� ���α׷��� ���� Class (Spring ���)
public class MainForSpring
{
	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException
	{
		// Spring���κ��� ��ü�� ���������� ����
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true)
		{
			System.out.println("��ɾ �Է��ϼ���.");
			System.out.print(">> ");
			
			// ��ɾ� �б�
			String command = reader.readLine();
			
			// ����
			if (command.startsWith("exit"))
			{
				System.out.println("�����մϴ�.\n");
				break;
			}
			
			// ȸ������
			if (command.startsWith("new "))
			{
				// �Է��� ������ ���� �������� ����
				processNewCommand(command.split(" "));
				continue;
			}
			
			// ��ȣ ����
			else if (command.startsWith("change "))
			{
				// �Է��� ������ ���� �������� ����
				processChangeCommand(command.split(" "));
				continue;
			}
			
			else if (command.startsWith("list"))
			{
				// �Է��� ������ ���� �������� ����
				processListCommand();
				continue;
			}
			
			else if (command.startsWith("info "))
			{
				// �Է��� ������ ���� �������� ����
				processInfoCommand(command.split(" "));
				continue;
			}
			
			else if (command.startsWith("version"))
			{
				processVersionCommand();
				continue;
			}
			
			// ����
			printHelp();
		}
	}
	
	// ȸ������ ���μ���
	private static void processNewCommand(String[] arg)
	{
		// �Էµ� ���ڿ� �迭�� ���� 5���� �ƴ� ���
		if (arg.length != 5)
		{
			printHelp();
			return;
		}
		
		// Spring Container�κ��� �̸��� memberRegSvc�� Bean�� ����. (AppCtx ����)
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		// ��ȣ�� ��ȣȮ���� ���� ��ġ���� ���� ���
		if (!req.isPasswordEqualToConfirmPassword())
		{
			System.out.println("��ȣ�� Ȯ���� ��ġ���� �ʽ��ϴ�.\n");
			return;
		}
		
		// ȸ�� ���
		try
		{
			regSvc.regist(req);
			System.out.println("����߽��ϴ�.\n");
		}
		
		// ����Ϸ��� �̸����� �̹� ���� ���
		catch (DuplicateMemberException e)
		{
			System.out.println("�̹� �����ϴ� �̸����Դϴ�.\n");
		}
	}
	
	// ��ȣ ���� ���μ���
	private static void processChangeCommand(String[] arg)
	{
		// �Էµ� ���ڿ� �迭�� ���� 4���� �ƴ� ���
		if (arg.length != 4)
		{
			printHelp();
			return;
		}
		
		// Spring Container�κ��� �̸��� changePwdSvc�� Bean�� ����. (AppCtx ����)
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		// ��ȣ ����
		try
		{
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("��ȣ�� �����߽��ϴ�.\n");
		}
		
		// �Է��� �̸����� �������� ���� ���
		catch (MemberNotFoundException e)
		{
			System.out.println("�������� �ʴ� �̸����Դϴ�.\n");
		}
		
		// ���� ��ȣ�� ��ġ���� ���� ���
		catch (WrongIdPasswordException e)
		{
			System.out.println("�̸��ϰ� ��ȣ�� ��ġ���� �ʽ��ϴ�.\n");
		}
	}
	
	// ȸ������ �ϰ���� ���μ���
	private static void processListCommand()
	{
		// Spring Container�κ��� �̸��� listPrinter�� Bean�� ����. (AppCtx ����)
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	// �ش� Email�� ���� ȸ������ ��� ���μ���
	private static void processInfoCommand(String[] arg)
	{
		// �Էµ� ���ڿ� �迭�� ���� 2���� �ƴ� ���
		if (arg.length != 2)
		{
			printHelp();
			return;
		}
		
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	// ���α׷��� Version ��� ���μ���
	private static void processVersionCommand()
	{
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
	
	// ��ɾ� ����
	private static void printHelp()
	{
		System.out.println();
		System.out.println("===================================");
		System.out.println("             ��ɾ�\n");
		System.out.println("new �̸��� �̸� ��ȣ ��ȣȮ��");
		System.out.println("change �̸��� �����ȣ �����ȣ");
		System.out.println("list");
		System.out.println("info �̸���");
		System.out.println("===================================\n");
	}
}