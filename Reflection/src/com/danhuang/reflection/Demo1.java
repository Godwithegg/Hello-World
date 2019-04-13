package com.danhuang.reflection;

/**
 * Class����Ļ�ȡ��ʽ
 * @author danhuang
 *
 */
@SuppressWarnings("all")
public class Demo1 {
	
	public static void main(String[] args) {
		String path = "com.danhuang.reflection.bean.User";
		
		try {
			Class clz = Class.forName(path);
			//�����Ǳ�ʾ���װ����һЩ���ݣ�һ���౻���غ�JVM�ᴴ��һ����Ӧ���Class������������ṹ��Ϣ�ᱻ�ŵ���Ӧ��Class������
			//���Class���������һ�澵��һ����ͨ�����澵�����ǿ��Կ�����Ӧ���ȫ����Ϣ
			System.out.println(clz);
			
			Class clz2 = Class.forName(path);//һ����ֻ��Ӧһ��Class���󣨷������
			System.out.println(clz.hashCode() == clz2.hashCode());
			
			Class strClz = String.class;
			Class strClz2 = path.getClass();
			System.out.println(strClz.hashCode() == strClz2.hashCode());
			
			int[] arr01 = new int[10];
			int[] arr02 = new int[30];
			System.out.println(arr01.getClass().hashCode() == arr02.getClass().hashCode());//�Ƚϵ���ά�Ⱥ�����,ֻ����ά�������й�ϵ
			
			int[][] arr03 = new int[10][10];
			System.out.println(arr01.getClass().hashCode() == arr03.getClass().hashCode());
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}
