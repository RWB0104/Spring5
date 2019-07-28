package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		// 변수는 달라도 변수에 할당되는 객체는 같음
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
	}
}