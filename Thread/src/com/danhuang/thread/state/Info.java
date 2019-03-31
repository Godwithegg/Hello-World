package com.danhuang.thread.state;

/**
 * ��������
 * isAlive���Ƿ����
 * Thread.currentThread()��ǰ�߳�
 * setName,getName:��������
 * 
 * @author danhuang
 *
 */
public class Info {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isAlive());

		// �������֣���ʵ��ɫ+�����ɫ
		MyInfo info = new MyInfo("ս����");
		Thread t = new Thread(info);
		t.setName("����");
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.isAlive());
	}
}

class MyInfo implements Runnable {
	private String name;

	public MyInfo(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+name);
	}
}