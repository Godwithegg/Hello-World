package com.danhuang.server.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
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
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// SAX����
		// 1.��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 2.�ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		// 3.��д������
		// 4.�����ĵ�Documentע�ᴦ����
		PersonHandler handler = new PersonHandler();
		// 5.����
		parse.parse(
				Thread.currentThread().getContextClassLoader().getResourceAsStream("com/danhuang/server/basic/p.xml"),
				handler);
		// ��ȡ����
		List<Person> persons = handler.getPersons();
		for (Person person : persons) {
			System.out.println(person.getName() + "-->" + person.getAge());
		}
	}
}

class PersonHandler extends DefaultHandler {
	private List<Person> persons;
	private Person person;
	private String tag;// �洢�����ı�ǩ

	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<>();
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName != null) {
			tag = qName;
		}
		if (tag.equals("person")) {
			person = new Person();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName != null && qName.equals("person")) {
			persons.add(person);
		}
		tag = null;// tag������
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String contents = new String(ch, start, length).trim();
		if (null != tag) { // �����˿�
			if (tag.equals("name")) {
				person.setName(contents);
			} else if (tag.equals("age")) {
				if (contents.length() > 0) {
					person.setAge(Integer.valueOf(contents));
				}
			}
		}
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
