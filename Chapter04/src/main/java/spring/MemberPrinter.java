package spring;

import java.time.format.DateTimeFormatter;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.lang.Nullable;

// =====================================================================================
// @Autowired�� �ҽ��� ���۰� ������� ��Ī�Ǵ� Bean�� ���� ��� ���ܸ� �߻�
// required �Ӽ��� false�� �����ϸ� ��Ī�Ǵ� Bean�� ������ ��ü �ڵ������� �������� ����
// Nullable�� Bean�� �������� �ʾƵ� Method�� ȣ���
// repuired false ������ ��� Bean�� �������� ������ Method�� ȣ����� ����
// =====================================================================================

// ȸ�� ������ ��������ϴ� Class
public class MemberPrinter
{
	private DateTimeFormatter dateTimeFormatter;
	
	// ȸ�� ���� �ܼ� Colsole ���
	public void print(Member member)
	{
		if (dateTimeFormatter == null)
		{
			System.out.printf("ȸ�� ���� : ���̵�=%d, �̸���=%s, �̸�=%s, �����=%tF\n", member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		}
		
		else
		{
			System.out.printf("ȸ�� ���� : ���̵�=%d, �̸���=%s, �̸�=%s, �����=%tF\n", member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
	// dateTimeFormatter ��ü �ڵ����� (�ʼ� �ƴ�)
	@Autowired(required =  false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter)
	{
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
	// Optional �Ӽ��� ����ص� required�� ������ ����� �ο��� �� ����
	/*
	@Autowired
	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt)
	{
		// ��ġ�ϴ� Bean�� ���� ���
		if (formatterOpt.isPresent())
		{
			this.dateTimeFormatter = formatterOpt.get();
		}
		
		// ��ġ�ϴ� Bean�� ���� ���
		else
		{
			this.dateTimeFormatter = null;
		}
	}
	*/
	
	// Nullable �Ӽ��� ����ص� required�� ������ ����� �ο��� �� ����
	/*
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter)
	{
		this.dateTimeFormatter = dateTimeFormatter;
	}
	*/
}