package com.danhuang.thread.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ������ȣ� Timer��TimerTask��
 * 
 * @author danhuang
 *
 */
public class MyTimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//ִ�а���
		
		timer.schedule(new MyTask(), 1000);	//ִ��һ��
		timer.schedule(new MyTask(), 1000,200);	//ÿ��200����ִ��һ��
		Calendar calendar = new GregorianCalendar(2099,12,21,23,23,23);
		timer.schedule(new MyTask(),calendar.getTime(),200);//ָ��ʱ���ʼ��ÿ��200����ִ��һ��
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("��Ϣһ��");
		}
		System.out.println("end");
	}
}