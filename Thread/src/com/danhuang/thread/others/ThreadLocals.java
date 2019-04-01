package com.danhuang.thread.others;

/**
 * ÿ���߳�����Ĵ洢���ء��ֲ�����
 * ÿ���߳���������ݣ����Ĳ���Ӱ�������߳�
 * get/set/initialValue
 * @author danhuang
 *
 */
public class ThreadLocals {
	//private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	//���ĳ�ʼֵ
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//		protected Integer initialValue() {
//			return 200;
//		};
//	};
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1 );
	public static void main(String[] args) {
		//��ȡֵ
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		//����ֵ
		threadLocal.set(99);
		System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		
		new Thread(new MyRun()).start();
	}
	public static class MyRun implements Runnable{
		@Override
		public void run() {
			threadLocal.set((int)(Math.random()*99));
			System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
		}
	}
}
