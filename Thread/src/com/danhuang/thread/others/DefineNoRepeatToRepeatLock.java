package com.danhuang.thread.others;

/**
 * ���������� ����������ʹ��+������
 * 
 * @author danhuang
 *
 */
public class DefineNoRepeatToRepeatLock {
	ReLock lock = new ReLock();
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
		DefineNoRepeatToRepeatLock define = new DefineNoRepeatToRepeatLock();
		define.a();

		Thread.sleep(1000);
		System.out.println(define.lock.getHoldCount());
	}
}

class ReLock{
	//�Ƿ�ռ��
	private boolean isLocked = false;
	private Thread lockedBy = null;//�洢�߳�
	private int holdCount = 0;
	//ʹ����
	public synchronized void lock() throws InterruptedException {
		Thread t = Thread.currentThread();
		while(isLocked && lockedBy != t) {
			wait();
		}
		isLocked = true;
		lockedBy = t;
		holdCount ++;
	}
	public int getHoldCount() {
		return holdCount;
	}
	public void setHoldCount(int holdCount) {
		this.holdCount = holdCount;
	}
	//�ͷ���
	public synchronized void unlock() {
		if(Thread.currentThread() == lockedBy) {
			holdCount --;
			if(holdCount == 0) {
				isLocked = false;
				notifyAll();
				lockedBy = null;
			}
		}
		
	}
}