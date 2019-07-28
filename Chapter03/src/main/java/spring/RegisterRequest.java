package spring;

// 회원가입에 필요한 간단한 정보를 포함하는 Class
public class RegisterRequest
{
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getConfirmPassword()
	{
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	// 암호와 확인암호의 일치여부 반환
	public boolean isPasswordEqualToConfirmPassword()
	{
		return password.equals(confirmPassword);
	}
}