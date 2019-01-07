package com.zs.demo1.daoimpl;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;

import com.zs.demo1.dao.Dao;

public class Daoimpl implements Dao {
	// 创建map映射
	private Map<String, Object> beans = new HashMap<String, Object>();
	// 声明对象
	Document doc=null;
	Object car=null;
	public void ClassPathXmlApplicationContext(String file1) {
		// 创建读解析器
		SAXReader reader = new SAXReader();
//		获取文件
		File file=new File(file1);
		try {
			// 读取到内存
		doc = reader.read(file);
			// 获取根元素
			Element e = doc.getRootElement();
			// 获取根元素下的子元素
			List<Element> list = e.elements("bean");
			// 遍历
			for (Element el : list) {
				// 获取class属性值
				String cname = e.attributeValue("class");
				// 获取id属性值
				String iname = e.attributeValue("id");
				// 创建对象
				car = Class.forName(cname).newInstance();
				// 4.存储对象
				beans.put(iname, car);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
 public Daoimpl(String file) {
	 ClassPathXmlApplicationContext( file);
}
	@Override
	public Object getCar(String id) {
		// 通过键值对获取对象
		return beans.get(id);
	}
	public static void main(String[] args) {
		Daoimpl d=new Daoimpl("bean.xml");
		
		
	}

}
