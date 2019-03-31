package com.danhuang.thread.concurrent;

/**
 * �̲߳���ȫ��ȡǮ
 * 
 * @author danhuang
 *
 */
public class Unsafe3 {
	public static void main(String[] args) {
		// �˻�
		Account account = new Account(100, "������");
		Drawing you = new Drawing(account, 80, "�ɱ�����");
		Drawing wife = new Drawing(account, 90, "���ĵ���");
		you.start();
		wife.start();
	}
}

class Account {
	int money;// ���
	String name;// ����

	public Account(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

}

// ģ��ȡ��
class Drawing extends Thread {

	Account account;// ȡǮ���˻�
	int drawingMoney;// ȡǮ��
	int packetTotal;// ȡǮ����

	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		if (account.money - drawingMoney < 0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money -= drawingMoney;
		packetTotal += drawingMoney;
		System.out.println(this.getName() + "-->�˻����Ϊ" + account.money);
		System.out.println(this.getName() + "-->�ڴ�ʣ��" + packetTotal);
	}
}