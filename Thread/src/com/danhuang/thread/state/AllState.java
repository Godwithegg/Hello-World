package com.danhuang.thread.state;

import java.lang.Thread.State;

/**
 * �۲��̵߳�״̬
 * 
 * @author danhuang
 *
 */
public class AllState {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("...");
			}
		});
		// �۲�״̬
		State state = t.getState();
		System.out.println(state);// new״̬

		t.start();
		state = t.getState();
		System.out.println(state);// runnable

		while (state != Thread.State.TERMINATED) {
			//�������
			//int num = Thread.activeCount();
			//if(num == 1)break;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state = t.getState(); // TIMED_WAITING
			System.out.println(state);
		}
		state = t.getState(); // terminated
		System.out.println(state);
	}
}
