package spring;

// 프로그램의 Version을 출력하는 Class
public class VersionPrinter
{
	private int majorVersion;
	private int minorVersion;
	
	// 버전 출력
	public void print()
	{
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n", majorVersion, minorVersion);
	}
	
	// Setter를 통한 MajorVersion 주입
	public void setMajorVersion(int majorVersion)
	{
		this.majorVersion = majorVersion;
	}
	
	// Setter를 통한 MinorVersion 주입
	public void setMinorVersion(int minorVersion)
	{
		this.minorVersion = minorVersion;
	}
}