package com.danhuang.thread.others;

/**
 * Volatile���ڱ�֤���ݵ�ͬ����Ҳ���ǿɼ���
 * 
 * @author danhuang
 *
 */
public class Volatile {
	private volatile static int num = 0;

	public static void main(String[] args) {
		new Thread(() -> {
			while (num == 0) {// �˴�����д����,����volatile����ѭ��
			}
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		num = 1;

	}
}
