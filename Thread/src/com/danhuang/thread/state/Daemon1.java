package com.danhuang.thread.state;

/**
 * �ػ��̣߳���Ϊ�û��̷߳���ģ�jvmֹͣ���õȴ��ػ��߳�ִ����� Ĭ�ϣ��û��߳� jvm��Ҫ�ȴ����е��û��߳�ִ����ϲŻ�ֹͣ
 * 
 * @author danhuang
 *
 */
public class Daemon1 {
	public static void main(String[] args) {
		God god = new God();
		You you = new You();
		Thread t1 = new Thread(god);
		t1.setDaemon(true);// ���û��̵߳���Ϊ�ػ��߳�
		t1.start();
		Thread t2 = new Thread(you);
		t2.start();
	}
}

class You implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 365 * 100; i++) {
			System.out.println("happe life...");
		}
		System.out.println("ooooo...");
	}
}

class God implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("bless you...");
		}
	}
}