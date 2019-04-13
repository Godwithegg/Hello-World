package com.danhuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.danhuang.reflection.bean.User;

/**
 * ͨ������api��̬�Ĳ�����������������������
 * 
 * @author danhuang
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		String path = "com.danhuang.reflection.bean.User";

		try {
			Class<User> clz = (Class<User>) Class.forName(path);
			// ͨ����̬���ù��췽�����������
			User u = clz.newInstance();
			System.out.println(u);
			
			Constructor<User> c = clz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = c.newInstance(1001,18,"����");
			System.out.println(u2.getUname());
			
			//ͨ������api������ͨ����
			User u3 = clz.newInstance();
			Method method = clz.getDeclaredMethod("setUname", String.class);
			method.invoke(u3, "������");
			System.out.println(u3.getUname());
			
			//ͨ������api��������
			User u4 = clz.newInstance();
			Field f = clz.getDeclaredField("uname");
			f.setAccessible(true);//������Բ���Ҫ��ȫ����� ������ֱ�ӷ���
			f.set(u4, "������");//ͨ������ֱ��д����
			System.out.println(u4.getUname());//ͨ������ֱ�Ӷ����Ե�ֵ
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
