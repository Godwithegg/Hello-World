package com.danhuang.thread.others;

/**
 * ������������ ������������ʹ��,��˻������ѭ��
 * 
 * @author danhuang
 *
 */
public class DefineRepeatLockToNoRepeat {
	Lock lock = new Lock();
	public void a() throws InterruptedException {
		lock.lock();
		doSomething();
		lock.unlock();
	}
	//��������
	public void doSomething() throws InterruptedException {
		lock.lock();
		//...
		lock.unlock();
	}
	public static void main(String[] args) throws InterruptedException {
		DefineRepeatLockToNoRepeat define = new DefineRepeatLockToNoRepeat();
		define.a();
		define.doSomething();
	}
}

class Lock{
	//�Ƿ�ռ��
	private boolean isLocked = false;
	//ʹ����
	public synchronized void lock() throws InterruptedException {
		while(isLocked) {
			wait();
		}
		isLocked = true;
	}
	//�ͷ���
	public synchronized void unlock() {
		isLocked = false;
		notifyAll();
	}
}