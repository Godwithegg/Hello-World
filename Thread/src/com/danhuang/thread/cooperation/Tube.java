package com.danhuang.thread.cooperation;

/**
 * Э��ģ�ͣ�
 * 	������������ʵ�ַ�ʽһ���̷ܳ�
 * 	����������
 * @author danhuang
 *
 */
public class Tube {
	public static void main(String[] args) {
		SynContainer synContainer = new SynContainer();
		Customer customer = new Customer(synContainer);
		Productor productor = new Productor(synContainer);
		customer.start();
		productor.start();
	}
}

// ������
class Productor extends Thread {
	private SynContainer synContainer;

	public Productor(SynContainer synContainer) {
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		// ����
		for (int i = 1; i <= 30; i++) {
			System.out.println("������-->" + i + "����ͷ");
			synContainer.push(new Steamedbun(i));
		}
	}
}

// ������
class Customer extends Thread {
	private SynContainer synContainer;

	public Customer(SynContainer synContainer) {
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		// ����
		for (int i = 1; i <= 30; i++) {
			System.out.println("�Ե�-->" + synContainer.pop().id + "����ͷ");

		}
	}
}

// ������
class SynContainer {
	Steamedbun[] buns = new Steamedbun[10];// �洢���ݵ�����
	int count = 0;// ������
	// �洢 ����

	public synchronized void push(Steamedbun bun) {
		// ��ʱ���������������ڿռ�
		// ��������
		if (count == buns.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// ���ڿռ䣬��������
		buns[count] = bun;
		count++;
		// �������� ����֪ͨ������
		this.notifyAll();
	}

	// ��ȡ
	public synchronized Steamedbun pop() {
		// ��ʱ���� �������Ƿ��������
		// ���û������ ֻ�еȴ�
		if (count == 0) {
			try {
				this.wait(); // �߳����� ������֪ͨ���� ���
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// �������� ��������
		count--;
		Steamedbun bun = buns[count];
		this.notifyAll();// ���ڿռ䣬���Ի��ѶԷ�����
		return bun;
	}
}

// ��ͷ
class Steamedbun {
	int id;

	public Steamedbun(int id) {
		super();
		this.id = id;
	}

}
