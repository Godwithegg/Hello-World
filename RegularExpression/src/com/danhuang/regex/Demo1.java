package com.danhuang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ʽ�Ļ����÷�
 * @author danhuang
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		//������ַ�����asfsdf23323adsafaf22455�У��Ƿ����ָ����������ʽ
		
		//���ʽ����
		Pattern p = Pattern.compile("\\w+");
		
		//����Matcher����
		Matcher m = p.matcher("absd2&&f");
		
//		boolean yesorno = m.matches();//���Խ������ַ��������ģʽƥ��
//		System.out.println(yesorno);

//		boolean yesorno2 = m.find();//�÷���ɨ����������У��������ģʽƥ�����һ�������У�
//		System.out.println(yesorno2);
		
		while(m.find()) {
			System.out.println(m.group());//absd2 -> f -> null
		}
		
	}
}
