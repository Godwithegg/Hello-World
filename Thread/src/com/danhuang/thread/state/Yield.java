package com.danhuang.thread.state;

/**
 * yield�����̣߳���ͣ�߳� ֱ�ӽ������״̬��������״̬
 * 
 * @author danhuang
 *
 */
public class Yield {
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda..."+i);
			}
		}).start();
		for (int i = 0; i < 100; i++) {
			System.out.println("main start..."+i);
			if (i % 20 == 0) {
				//Thread.yield();	//main�߳�����
				System.out.println("main middle");
			}
			System.out.println("main end..."+i);
		}
	}
}

class MyYield implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-->start");
		Thread.yield();// ����
		System.out.println(Thread.currentThread().getName() + "-->end");
	}
}
