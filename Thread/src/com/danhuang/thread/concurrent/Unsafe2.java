package com.danhuang.thread.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * �̲߳���ȫ����������
 * @author danhuang
 *
 */
public class Unsafe2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<100;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
		}
		System.out.println(list.size());
	}
}