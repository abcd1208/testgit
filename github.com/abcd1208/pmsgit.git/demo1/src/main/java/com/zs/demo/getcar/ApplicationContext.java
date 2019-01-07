package com.zs.demo.getcar;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zs.demo1.CarBean;

public class ApplicationContext {
	// 创建map映射
	Map<String, Object> cars = new HashMap<>();
	// 声明document对象
	Document doc = null;
	// 声明car对象
	Object car = null;
	String ename=null;
	String  evalue=null;
	// 读xml
	private void applicationContext(String file) {
		// 读取文件
		InputStream is = ApplicationContext.class.getClassLoader().getResourceAsStream(file);
		// 创建读解析器
		SAXReader saxReader = new SAXReader();
		// 读取到内存
		try {
			doc = saxReader.read(is);
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// 获取根元素
		Element root = doc.getRootElement();
		// 获取根元素下的子元素
		List<Element> list = root.elements("bean");
		for (Element e : list) {
			String cname = e.attributeValue("class");
			String iname = e.attributeValue("id");
			//获取子元素下的子元素
			//获取子元素下的下一级元素
			List<Element>elem=e.elements();
			for (Element eleme : elem) {
				ename=eleme.attributeValue("name");
			    evalue=eleme.attributeValue("value");
			}
			// 3.获取对象
			try {
				// 获取类模板
				Class cl = Class.forName(cname);
//				获取类方法
				Method m=cl.getMethod("setSpeed", int.class);
				// 获取对象
				car = cl.newInstance();
				//动态执行方法
				m.invoke("car", 100);

			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 4.存储对象
			cars.put(iname, car);
		}
	}

	// 构造函数初始化
	public ApplicationContext(String file) {
		applicationContext(file);
	}

	// 通过id获取对象
	public Object getBean(String id) {
		return cars.get(id);
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ApplicationContext("bean.xml");
		CarBean car = (CarBean) ac.getBean("car");
		car.addSpeed(10);
		System.out.println("汽车速度为:" + car.getSpeed());
	}
}
