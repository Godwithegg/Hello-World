package com.danhuang.thread.concurrent;

/**
 * ��������� ����:�����ͬ��������ɻ��಻�ͷ���Դ �Ӷ��໥�ȴ���һ�㷢����ͬ���г��ж��������� 
 * ���⣺��Ҫ��ͬһ��������У�ͬʱ���ж���������
 * 
 * @author danhuang
 *
 */
public class SolveDeadLock {
	public static void main(String[] args) {
		Makeup1 makeup1 = new Makeup1("С��", 0);
		Makeup1 makeup2 = new Makeup1("С��", 1);
		makeup1.start();
		makeup2.start();
	}
}

class Makeup1 extends Thread {
	// ����
	private String name;
	// ѡ��
	private int choice;
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();

	public Makeup1(String name, int choice) {
		this.name = name;
		this.choice = choice;
	}

	@Override
	public void run() {
		// ��ױ
		makeup();
	}

	// �໥���жԷ�����
	public void makeup() {
		if (choice == 0) {
			synchronized (lipstick) {
				System.out.println(this.name + "��ʼͿ�ں�");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			synchronized (mirror) {
				System.out.println(this.name + "��ʼ�վ���");
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.name + "��ʼͿ�ں�");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			synchronized (lipstick) {
				System.out.println(this.name + "��ʼ�վ���");
			}
		}
	}
}
