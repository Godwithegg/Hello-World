package com.danhuang.jvm;

/**
 * ����ع���:����ĳ�ʼ����->��ǰ��ĳ�ʼ����->��ķ���
 * ��������
 * 	1����̬����
 * 	2����̬����
 * 	3��������
 * 		Demo1��...
 * 	4����Ĵ���
 * �ѣ�
 * 	1��java.lang.Class����
 * 	2������Demo1��
 * 	
 * @author danhuang
 *
 */
public class Demo1 {
	static {
		System.out.println("��̬��ʼ��Demo1");
	}
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Demo1��main����");
		
		/**
		 * �������ã�������ʼ��
		 * 1��new һ�������ʱ
		 * 2��������ľ�̬��Ա������final�������;�̬����
		 * 3��ʹ�÷��������з������
		 * 4���������������java Demo1����һ�����ʼ��Demo1�࣬˵���˾�������main�������ڵ���
		 * 5������ʼ��һ���࣬����丸��û�б���ʼ��������ȳ�ʼ�����ĸ���
		 */
//		A a = new A();
//		System.out.println(a.width);
//		A a2 = new A();//��̬��ʼ����ֻ������һ��
//		Class.forName("com.danhuang.jvm.A");
		
		/**
		 * ��ı������ã����ᷢ����ĳ�ʼ��
		 * 1��������һ����̬��ʱ��ֻ������������������Żᱻ��ʼ��
		 * 		ͨ���������ø���ľ�̬���������ᵼ�������ʼ��
		 * 2��ͨ�����鶨�������ã����ᴥ������ĳ�ʼ��
		 * 3�����ó������ᴥ������ĳ�ʼ���������ڱ���׶ξʹ�����ĳ��������ˣ�
		 */
//		System.out.println(A.MAX);
//		A[] as = new A[10];
		System.out.println(B.width);
	}
}

class A extends A_Father{
	public static int width = 100;	//��̬��������̬�� field
	public static final int MAX = 100;
	static {
		System.out.println("��̬��ʼ����A");
		width = 300;
	}

	public A() {
		System.out.println("����A�Ķ���");
	}
}

class A_Father{
	static {
		System.out.println("��̬��ʼ��A_Father");
	}
}

class B extends A{
	static {
		System.out.println("��̬��ʼ��B");
	}
}