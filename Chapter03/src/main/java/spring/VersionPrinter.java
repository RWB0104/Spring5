package spring;

// ���α׷��� Version�� ����ϴ� Class
public class VersionPrinter
{
	private int majorVersion;
	private int minorVersion;
	
	// ���� ���
	public void print()
	{
		System.out.printf("�� ���α׷��� ������ %d.%d�Դϴ�.\n\n", majorVersion, minorVersion);
	}
	
	// Setter�� ���� MajorVersion ����
	public void setMajorVersion(int majorVersion)
	{
		this.majorVersion = majorVersion;
	}
	
	// Setter�� ���� MinorVersion ����
	public void setMinorVersion(int minorVersion)
	{
		this.minorVersion = minorVersion;
	}
}