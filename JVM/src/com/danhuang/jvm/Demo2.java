package com.danhuang.jvm;

/**
 * ����ػ��ƣ�����ȫ���ǣ���tomcat���ȼ��������Ҳ����Ŵ���������������
 * ˫��ί�л��ƣ�
 * 	ĳ���ض�����������ڽӵ������������ʱ�����Ƚ���������ί�и���������������λ��ݣ�ֱ����ߵ�үү�������������������������������񣬾ͳɹ����ء�
 * 	ֻ�и���������޷���ɴ˼�������ʱ�����Լ�ȥ���ء�
 * Ŀ�ģ���֤java���Ŀ�����Ͱ�ȫ��
 * @author danhuang
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		System.out.println(ClassLoader.getSystemClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//�������������ԭ������ʵ��
		
		System.out.println(System.getProperty("java.class.path"));
		
		System.out.println("-------------------");
		String a = "dan";//�����jdk�İ���������ͻ�ˣ���������˫��ί�л�����������಻�ᱻ����
		System.out.println(a.getClass().getClassLoader());
		System.out.println(a);
		
		
	}
}
