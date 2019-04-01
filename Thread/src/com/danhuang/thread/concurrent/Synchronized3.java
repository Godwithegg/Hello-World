package com.danhuang.thread.concurrent;

/**
 * �̰߳�ȫ��ͬ���죬Ŀ�����ȷ
 * 
 * @author danhuang
 *
 */
public class Synchronized3 {
	public static void main(String[] args) {
		// �˻�
		Account2 account = new Account2(200, "������");
		Drawing2 you = new Drawing2(account, 80, "�ɱ�����");
		Drawing2 wife = new Drawing2(account, 90, "���ĵ���");
		you.start();
		wife.start();
	}
}

class Account2 {
	int money;// ���
	String name;// ����

	public Account2(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}

}

// ģ��ȡ��
class Drawing2 extends Thread {

	Account2 account2;// ȡǮ���˻�
	int drawingMoney;// ȡǮ��
	int packetTotal;// ȡǮ����

	public Drawing2(Account2 account2, int drawingMoney, String name) {
		super(name);
		this.account2 = account2;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}

	public void test() {
		//������������������ȥû�н��ʱ��Ҫѯ�ʶ���
		if(account2.money <= 0) {
			return ;
		}
		//ͬ����
		synchronized (account2) {
			if (account2.money - drawingMoney < 0) {
				return;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account2.money -= drawingMoney;
			packetTotal += drawingMoney;
			System.out.println(this.getName() + "-->�˻����Ϊ" + account2.money);
			System.out.println(this.getName() + "-->�ڴ�ʣ��" + packetTotal);
		}
	}
}