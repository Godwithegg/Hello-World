package com.danhuang.thread.create;

interface ILove{
	int lambda(int a,int b);
}
public class Lambda_class2 {
	public static void main(String[] args) {
		ILove love = (a,b)->{
			System.out.println("I like "+(a+b));
			return a+b;
		};
		System.out.println(love.lambda(3, 4));
		//love = (a,b)->100;//�൱��дһ�����������ķ���������ֵ��100
		
	}
}
