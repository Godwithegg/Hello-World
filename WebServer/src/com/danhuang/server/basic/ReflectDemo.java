package com.danhuang.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * ���� 1����ȡClass���� ���ַ�ʽ��Class.forName("����·��") 
 * 2�����Զ�̬��������
 * clz.getConstructor.newInstance()
 * @author danhuang
 *
 */
public class ReflectDemo {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		// ���ַ�ʽ
		// 1������.getClass()
		Class clz = new Iphone().getClass();
		// 2����.class()
		clz = Iphone.class;
		// 3��Class.forName("����.����")
		clz = Class.forName("com.danhuang.server.basic.Iphone");

		// ��������
		Iphone iphone = (Iphone) clz.newInstance();// ���Ƽ�
		System.out.println(iphone);

		Iphone iphone2 = (Iphone) clz.getConstructor().newInstance();// �Ƽ�
		System.out.println(iphone2);
	}
}

class Iphone {
	public Iphone() {

	}
}
