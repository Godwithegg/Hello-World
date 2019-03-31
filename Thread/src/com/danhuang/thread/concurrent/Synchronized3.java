package com.danhuang.thread.concurrent;

/**
 * �̰߳�ȫ��ȡǮ
 * 
 * @author danhuang
 *
 */
public class Synchronized3 {
	public static void main(String[] args) {
		// �˻�
		Account1 account = new Account1(100, "������");
		Drawing1 you = new Drawing1(account, 80, "�ɱ�����");
		Drawing1 wife = new Drawing1(account, 90, "���ĵ���");
		you.start();
		wife.start();
	}
}

class Account1 {
	int money;// ���
	String name;// ����

	public Account1(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

}

// ģ��ȡ��
class Drawing1 extends Thread {

	Account1 account1;// ȡǮ���˻�
	int drawingMoney;// ȡǮ��
	int packetTotal;// ȡǮ����

	public Drawing1(Account1 account1, int drawingMoney, String name) {
		super(name);
		this.account1 = account1;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}

	public synchronized void test() {
		if (account1.money - drawingMoney < 0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account1.money -= drawingMoney;
		packetTotal += drawingMoney;
		System.out.println(this.getName() + "-->�˻����Ϊ" + account1.money);
		System.out.println(this.getName() + "-->�ڴ�ʣ��" + packetTotal);
	}
}