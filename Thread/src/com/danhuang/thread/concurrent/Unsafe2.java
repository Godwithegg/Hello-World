package com.danhuang.thread.concurrent;

/**
 * �̲߳���ȫ
 * �����и���
 * �������ظ�
 * @author danhuang
 *
 */
public class Unsafe2 implements Runnable {
	// Ʊ��
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while (true) {
			test();
		}
	}

	public void test() {
		if (ticketNums < 0) {
			flag = false;
			return;
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
	}

	public static void main(String[] args) {
		// һ����Դ
		Unsafe2 web = new Unsafe2();
		// �������
		new Thread(web, "����").start();
		new Thread(web, "��ũ").start();
		new Thread(web, "���").start();

	}
}
