package com.danhuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Ӧ�÷����api��ȡ�����Ϣ��������֣����ԣ���������������
 * 
 * @author danhuang
 *
 */
public class Demo2 {
	private static Field[] fields;

	public static void main(String[] args) {
		String path = "com.danhuang.reflection.bean.User";

		try {
			Class clz = Class.forName(path);
			
			//��ȡ�������
			System.out.println(clz.getName());//��ð���.����
			System.out.println(clz.getSimpleName());//�������
			
			//���������Ϣ
			fields = clz.getFields();//ֻ�ܻ��public��field
			Field[] declaredFields = clz.getDeclaredFields();//�������е�����
			Field declaredField = clz.getDeclaredField("uname");
			System.out.println(fields.length);
			System.out.println(declaredFields.length);
			for (Field field : declaredFields) {
				System.out.println("����"+field);
			}
			//��÷�����Ϣ ͬ��
			Method[] methods = clz.getMethods();
			Method[] declaredMethods = clz.getDeclaredMethods();
			Method declaredMethod = clz.getDeclaredMethod("getUname", null);
			Method declaredMethod2 = clz.getDeclaredMethod("setUname", String.class);//��������вα��봫�ݲ������Ͷ�ӦClass����
			for (Method method : declaredMethods) {
				System.out.println("����"+method);
			}
			
			//��ù�����Ϣ
			Constructor[] declaredConstructors = clz.getDeclaredConstructors();//������еĹ�����
			Constructor declaredConstructor = clz.getDeclaredConstructor(null);
			System.out.println("����޲ι�����"+declaredConstructor);
			Constructor declaredConstructor2 = clz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("��ô��ι�����"+declaredConstructor2);
			for (Constructor constructor : declaredConstructors) {
				System.out.println("������"+constructor);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
