package spring;

// ȸ������ ��, ������ �̸����� �̹� ������ ��� ���ܸ� �߻��ϴ� Class
@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException
{
	public DuplicateMemberException(String message)
	{
		super(message);
	}
}