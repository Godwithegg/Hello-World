package com.danhuang.thread.create;

/**
 * �����̣߳���ʽһ��
 * 	�������̳�Thread+��дrun
 * @author danhuang
 *
 */
public class StartThread extends Thread{
	/**
	 * �߳���ڵ�
	 */
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("һ������");
		}
	}
	public static void main(String[] args) {
		//�����������
		StartThread st = new StartThread();
		//����
		st.start();	//����֤�������У���cpu����
		//st.run();//��ͨ��������
		for(int i=0;i<20;i++) {
			System.out.println("һ��coding");
		}
	}
}
