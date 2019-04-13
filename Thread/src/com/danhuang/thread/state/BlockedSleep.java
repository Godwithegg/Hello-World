package com.danhuang.thread.state;

import com.danhuang.thread.shareresource.Web12306;

/**
 * sleepģ��������ʱ���Ŵ��˷�������Ŀ����� 
 * @author danhuang
 *
 */
public class BlockedSleep implements Runnable{
	// Ʊ��
	private int ticketNums = 99;

	@Override
	public void run() {
		while (true) {
			if (ticketNums < 0) {
				break;
			}
			//ģ����ʱ
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
		}
	}

	public static void main(String[] args) {
		// һ����Դ
		Web12306 web = new Web12306();
		// �������
		new Thread(web, "����").start();
		new Thread(web, "��ũ").start();
		new Thread(web, "���").start();

	}
}
