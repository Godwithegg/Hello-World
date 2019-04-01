package com.danhuang.thread.others;

/**
 * ����ģʽ������ʽ��·�����ϼ��벢�����ƣ��ڲ��������£��������һ������
 * 1��������˽�л�-->�����ⲿnew������
 * 2���ṩ˽�еľ�̬����-->�洢����ĵ�ַ
 * 3���ṩ�����ľ�̬����-->��ȡ����
 * @author danhuang
 *
 */
public class DoubleCheckedLocked { 
	//2.�ṩ˽�еľ�̬����
	private static volatile DoubleCheckedLocked instance;
	//û��volatile�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
	private DoubleCheckedLocked() {		
		
	}
	public static DoubleCheckedLocked getInstance() {
		//�ٴμ��
		if(instance != null) {//���ⲻ��Ҫ��ͬ�����Ѿ����ڶ���
			return instance;
		}
		synchronized(DoubleCheckedLocked.class) {
			if(instance == null) {
				instance = new DoubleCheckedLocked();
				//1.���ٿռ�
				//2.��ʼ��������Ϣ
				//3.���ض����ַ������
			}	
		}
		
		return instance;
	}
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			System.out.println(DoubleCheckedLocked.getInstance());
		});
		t.start();
	}
}
