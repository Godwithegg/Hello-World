package com.danhuang.thread.create;

/**
 * Lambada���ʽ���̣߳���һ�Σ���ʹ��
 * 
 * @author danhuang
 *
 */
public class LambdaThread {
	public static void main(String[] args) {
		new Thread(()-> {
			System.out.println("һ������");
		}).start();
		
	}
}
