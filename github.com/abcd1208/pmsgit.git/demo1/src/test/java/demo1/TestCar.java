package demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.demo1.CarBean;

public class TestCar {
	@Test
	public void testCar() {
		// 通过bean.xml让spring创建对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// 通过id获取对象
		CarBean car1 = (CarBean) ac.getBean("car");
		car1.getSpeed();
	}
}
