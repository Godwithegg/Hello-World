package com.danhuang.thread.create;

/**
 * �򻯶��߳�
 * 
 * @author danhuang
 *
 */
public class Lambda_class3 {
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("һ��ѧϰlambda");
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("һ��������");
			}
		}).start();

	}
}
