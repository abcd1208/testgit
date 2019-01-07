package demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zs.demo1.Man;

public class TestMan {
	@Test
public void testMan() {
	ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
	Man man =(Man)ac.getBean("man");
	man.drive();
};
}
