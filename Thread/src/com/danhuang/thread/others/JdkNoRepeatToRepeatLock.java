package com.danhuang.thread.others;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ���������� ����������ʹ��+������
 * 
 * @author danhuang
 *
 */
public class JdkNoRepeatToRepeatLock {
	ReentrantLock lock = new ReentrantLock();	//����ֱ��ʹ�ã�����Ҫ�Լ�д���ˣ�jdk�Դ���
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		doSomething();
		lock.unlock();
	}
	//��������
	public void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount());
		lock.unlock();
		System.out.println(lock.getHoldCount());
	}
	public static void main(String[] args) throws InterruptedException {
		JdkNoRepeatToRepeatLock define = new JdkNoRepeatToRepeatLock();
		define.a();

		Thread.sleep(1000);
		System.out.println(define.lock.getHoldCount());
	}
}