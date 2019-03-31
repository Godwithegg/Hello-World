package com.danhuang.thread.concurrent;

/**
 * �̰߳�ȫ������ʱ��֤���ݵ�׼ȷ�ԣ�Ч�ʾ����ܸ� synchronized 1��ͬ������ 2��ͬ����
 * 
 * @author danhuang
 *
 */
public class Synchronized1 {
	public static void main(String[] args) {
		SafeWeb12306 web = new SafeWeb12306();
		new Thread(web, "����").start();
		new Thread(web, "��ũ").start();
		new Thread(web, "���").start();
	}
}

class SafeWeb12306 implements Runnable {
	// Ʊ��
	private int ticketNums = 99;
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}
	}

	//�̰߳�ȫ ͬ��
	public synchronized void test() {
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

}
