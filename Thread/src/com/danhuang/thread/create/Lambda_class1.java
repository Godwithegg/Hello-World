package com.danhuang.thread.create;

interface ILike{
	void lambda(int a);
}
public class Lambda_class1 {
	public static void main(String[] args) {
		ILike like = (a)->{	//ֻ��һ��������������ſ���ʡ�ԣ�ֻ��һ�д��룬�����ſ���ʡ��
			System.out.println("I like lambda --->"+a);
		};
		like.lambda(10);
		//��Ϊ
		like = a->System.out.println("I like to->"+a);
		like.lambda(20);
	}
}
