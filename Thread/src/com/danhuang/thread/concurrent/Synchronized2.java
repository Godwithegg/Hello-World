package com.danhuang.thread.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * �̰߳�ȫ����������
 * 
 * @author danhuang
 *
 */
public class Synchronized2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		try {
			Thread.sleep(100);// ����ʱ��Ϊ�����߳�ִ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}