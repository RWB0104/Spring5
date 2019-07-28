package spring;

// 회원가입 시, 동일한 이메일이 이미 존재할 경우 예외를 발생하는 Class
@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException
{
	public DuplicateMemberException(String message)
	{
		super(message);
	}
}