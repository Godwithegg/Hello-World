package com.danhuang.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ʽ����ķָ��ַ�������
 * @author danhuang
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		String str = "a,b,c";
		String[] arrs = str.split(",");
		System.out.println(Arrays.toString(arrs));
		
		String str2 = "abc123,deg3";
		String[] arrs2 = str2.split("\\d");
		System.out.println(Arrays.toString(arrs2));
	}
}
