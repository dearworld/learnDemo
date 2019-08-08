package com.example.demo.xmlParse;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
	
	public static void main(String[] args) throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read("http://39.104.137.131:9156/stat");
		Element root = document.getRootElement();
		System.out.println(root.getName());
		Element serverEle = root.element("server");
		Element applicationEle = serverEle.element("application");
		System.out.println(applicationEle.getName());
		Element liveEle = applicationEle.element("live");
		System.out.println(liveEle.getName());
		for(Iterator<Element> it = liveEle.elementIterator(); it.hasNext();) {
			Element streamEle = (Element) it.next();
			if(!"nclients".equals(streamEle.getName())) {
				Element deviceEle = streamEle.element("name");
				if("864082010105693".equals(deviceEle.getText())) {
					Element nclientsEle = streamEle.element("nclients");
					System.out.println(nclientsEle.getText());
				}
			}
		}
	}
}
