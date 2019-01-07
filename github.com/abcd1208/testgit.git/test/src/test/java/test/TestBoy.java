package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.man.Boy;

public class TestBoy {
	@Test
	public void testBoy() {
		// 通过bean.xml让spring创建对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
		//获取boy对象
		Boy o = (Boy) ac.getBean("boy");
		o.makeFriend();

	};

}
