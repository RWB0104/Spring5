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

// ���� ���α׷��� ���� Class (Assembler ���)
public class MainForAssembler
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// ���� ����
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
			
			// ����
			printHelp();
		}
	}
	
	private static Assembler assembler = new Assembler();
	
	// ȸ������ ���μ���
	private static void processNewCommand(String[] arg)
	{
		// �Էµ� ���ڿ� �迭�� ���� 5���� �ƴ� ���
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
		
		ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
		
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
	
	// ��ɾ� ����
	private static void printHelp()
	{
		System.out.println();
		System.out.println("===================================");
		System.out.println("             ��ɾ�\n");
		System.out.println("new �̸��� �̸� ��ȣ ��ȣȮ��");
		System.out.println("change �̸��� �����ȣ �����ȣ");
		System.out.println("===================================\n");
	}
}