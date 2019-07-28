package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// �ش� Class�� Spring Configuration Class�� ����
@Configuration
public class AppContext
{
	// �ش� Method�� ������ ��ü�� Spring�� �����ϴ� �� ��ü�� ���
	@Bean
	public Greeter greeter()
	{
		Greeter g = new Greeter();
		g.setFormat("%s, �ȳ��ϼ���!");
		
		return g;
	}
	
	// �����Ǵ� ��ü �߰�
	@Bean
	public Greeter greeter1()
	{
		Greeter g = new Greeter();
		g.setFormat("�ȳ��ϼ���, %s��!");
		return g;
	}
}