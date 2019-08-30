package spring;

import java.time.LocalDateTime;

// 회원 데이터 표현을 위한 Class
public class Member
{
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password, String name,LocalDateTime regDateTime)
	{
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Long getId()
	{
		return id;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getName()
	{
		return name;
	}
	
	public LocalDateTime getRegisterDateTime()
	{
		return registerDateTime;
	}
	
	// 암호 변경
	public void changePassword(String oldPassword, String newPassword)
	{
		// 기존 암호와 변경할 암호가 같은 경우
		if (!password.equals(oldPassword))
		{
			// 오류 반환
			throw new WrongIdPasswordException();
		}
		
		this.password = newPassword;
	}
}