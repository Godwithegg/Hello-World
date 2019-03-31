package com.danhuang.thread.state;

/**
 * join:�ϲ��̣߳�����߳�
 * @author danhuang
 *
 */
public class BlockedJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("lambda..."+i);
			}
		});
		t.start();
		
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				t.join();	//��ӣ���Ȼ����main��������
			}
			System.out.println("main end..."+i);
		}
	}
}
