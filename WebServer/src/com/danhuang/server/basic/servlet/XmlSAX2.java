package com.danhuang.server.basic.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * ��ϤSAX�Ľ�������
 * 
 * @author danhuang
 *
 */
public class XmlSAX2 {
	public static void main(String[] args) throws Exception {
		// SAX����
		// 1.��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.�ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		// 3.��д������
		// 4.�����ĵ�Documentע�ᴦ����
		WebHandler handler = new WebHandler();
		// 5.����
		parse.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/danhuang/server/basic/servlet/web.xml"), handler);
		// ��ȡ����
		WebContext context = new WebContext(handler.getEntitys(), handler.getMappings());
		//������������ /login
		String className = context.getClz("/login");
		Class clz = Class.forName(className);
		Servlet servlet = (Servlet)clz.getConstructor().newInstance();
		//System.out.println(servlet);
		servlet.service();
	}
}

class WebHandler extends DefaultHandler {
	private List<Entity> entitys;
	private List<Mapping> mappings;
	private Entity entity;

	public List<Entity> getEntitys() {
		return entitys;
	}

	public void setEntitys(List<Entity> entitys) {
		this.entitys = entitys;
	}

	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	private Mapping mapping;
	private boolean isMapping = false;
	private String tag;// �洢�����ı�ǩ

	@Override
	public void startDocument() throws SAXException {
		entitys = new ArrayList<>();
		mappings = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName != null) {
			tag = qName;
		}
		if (tag.equals("servlet")) {
			entity = new Entity();
			isMapping = false;
		} else if (tag.equals("servlet-mapping")) {
			mapping = new Mapping();
			isMapping = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName != null) {
			if (qName.equals("servlet")) {
				entitys.add(entity);
			} else if (qName.equals("servlet-mapping")) {
				mappings.add(mapping);
			}
		}
		tag = null;// tag������
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (null != tag) { // �����˿�
			if (isMapping) {// ����servlet-mapping
				if (tag.equals("servlet-name")) {
					mapping.setName(contents);
				} else if (tag.equals("url-pattern")) {
					if (contents.length() > 0) {
						mapping.addPattern(contents);
					}
				}
			} else {// ����servlet
				if (tag.equals("servlet-name")) {
					entity.setName(contents);
				} else if (tag.equals("servlet-class")) {
					if (contents.length() > 0) {
						entity.setClz(contents);
					}
				}
			}

		}
	}

}
