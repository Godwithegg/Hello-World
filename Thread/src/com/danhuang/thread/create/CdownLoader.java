package com.danhuang.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CdownLoader implements Callable<Boolean> {

	private String url;// Զ��·��
	private String name;// �洢����

	public CdownLoader(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public Boolean call() throws Exception{
		WebDownLoader wd = new WebDownLoader();
		wd.downLoad(url, name);
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		CdownLoader td1 = new CdownLoader("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=574921756,1100726233&fm=173&app=49&f=JPEG?w=218&h=146&s=9446D2B2D27113989429BD3703005021", "./beautiful.jpg");
		CdownLoader td2 = new CdownLoader("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2241104856,2567260193&fm=173&app=49&f=JPEG?w=218&h=146&s=A23354859EB3B04B082BCD800300C08B", "./ugly.jpg");
		CdownLoader td3 = new CdownLoader("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=574921756,1100726233&fm=173&app=49&f=JPEG?w=218&h=146&s=9446D2B2D27113989429BD3703005021", "./nomal.jpg");
		
		//����ִ�з���
		ExecutorService ser = Executors.newFixedThreadPool(3);
		//�ύִ��
		Future<Boolean> future1 = ser.submit(td1);
		Future<Boolean> future2 = ser.submit(td2);
		Future<Boolean> future3 = ser.submit(td3);
		//��ȡ���
		boolean r1 = future1.get();
		boolean r2 = future2.get();
		boolean r3 = future3.get();
		//�رշ���
		ser.shutdown();
		
	}
}
