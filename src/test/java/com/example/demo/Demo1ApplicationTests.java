package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {
	
	@Autowired
	private Configuration configuration;

	@Test
	public void contextLoads() throws Exception{
		//创建一个Configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		//设置模板文件所在的路径
		configuration.setDirectoryForTemplateLoading(new File("src/main/resources/ftl"));
		//设置模板文件所使用的字符集，一般是utf-8
		configuration.setDefaultEncoding("utf-8");
		//加载一个模板，创建一个模板对象
		Template template = configuration.getTemplate("hello.ftl");
		//创建一个模板使用的数据集，可以是pojo也可以是map，一般是map
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "freemarker");
		 //创建一个writer对象，一般创建一个FileWriter对象，指定生成的文件名。
		PrintWriter out = new PrintWriter(new File("hello.html"));
		//调用模板对象的process方法输出文件
		template.process(map, out);
		//关闭资源
		out.close();
	}
	
	@Test
	public void test2() throws Exception{
		Template template = configuration.getTemplate("hello.ftl", "UTF-8");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "freemarker");
		String result = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		System.out.println(result);
	}
	
	@Test
	public void test3() throws Exception{
		Template template = configuration.getTemplate("hello.ftl", "UTF-8");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", "test Freemarker");
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("test.html")));
		template.process(map, writer);
		writer.close();
	}
}
