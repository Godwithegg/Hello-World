package com.danhuang.collection;

/**
 * ��ʶ�����еķ���
 * 
 * @author danhuang
 *
 */
public class Generic {
	public static void main(String[] args) {
		MyCollection<String> col = new MyCollection<String>();
		col.set("��ż", 0);
		col.set("����", 1);
		System.out.println(col.get(1));
	}
}

class MyCollection<E> {
	Object[] objs = new Object[10];

	public void set(E obj, int index) {
		objs[index] = obj;
	}

	public E get(int index) {
		return (E) objs[index];
	}
}
