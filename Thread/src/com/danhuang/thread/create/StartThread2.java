package com.danhuang.thread.create;

/**
 * �����̣߳���ʽ����
 * ʵ��runnable�ӿ�
 * ��дrun
 * �Ƽ�
 * 	���ⵥ�̳еľ�����
 * 	���㹲����Դ
 * @author danhuang
 *
 */
public class StartThread2 implements Runnable{
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
		
	/*
  		//�����������
		StartThread2 st = new StartThread2();
		//�������������
		Thread t = new Thread(st);
		//����
		t.start();	//����֤�������У���cpu����
		//st.run();//��ͨ��������
 	*/
		//���ϴ�����Ϊֻ�õ���һ�Σ���˽���ʹ�������ڲ���
		new Thread(new StartThread2()).start();
		for(int i=0;i<20;i++) {
			System.out.println("һ��coding");
		}
	}
}
