package com.danhuang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * ����������ʽ�еķ��鴦��
 * @author danhuang
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
		Matcher m = p.matcher("woshi123**shi*shi123");
		
		//�滻
		String newStr = m.replaceAll("#");
		System.out.println(newStr);
		 
	}
}
