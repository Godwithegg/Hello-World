package com.danhuang.jvm;

/**
 * �����Զ����FileSystemClassLoader
 * ����������������ص�ͬһ���࣬JVM����Ϊ����ͬ����
 * @author danhuang
 *
 */
public class Demo3 {
	public static void main(String[] args) throws Exception {
		FileSystemClassLoader loader = new FileSystemClassLoader("D:/github/javalearning/javalearing/JVM/");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("D:/github/javalearning/javalearing/JVM/");

		Class<?> c1 = loader.loadClass("TestClass");
		Class<?> c2 = loader.loadClass("TestClass");
		Class<?> c3 = loader2.loadClass("TestClass");
		Class<?> c4 = loader2.loadClass("java.lang.String");
		Class<?> c5 = loader.loadClass("com.danhuang.jvm.Demo2");
		Class<?> c6 = loader2.loadClass("com.danhuang.jvm.Demo2");
		
		System.out.println(c1);
		
		System.out.println(c1.hashCode() == c2.hashCode());
		System.out.println(c1.hashCode() == c3.hashCode());//����������������ص�ͬһ���࣬JVM����Ϊ����ͬ���ࡣ��������.class��classpath�£���ô��ͬһ����
		System.out.println(c5.hashCode() == c6.hashCode());//���������������ͬһ��classpath�£�������ͬһ����
		
		System.out.println(c3.getClassLoader());//�Զ����������
		System.out.println(c4.getClassLoader());//�����������
	}
}
