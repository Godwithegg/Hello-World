package com.danhuang.collection.arrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ʶ�����к�������صķ���
 * @author danhuang
 *
 */
public class MyList {
	public static void main(String[] args) {
		//useList();
		listIndex();
	}
	public static void useList() {
		List<String> list1 = new ArrayList<>();
		list1.add("aa");
		list1.add("bb");
		list1.add("cc");
		List<String> list2 = new ArrayList<>();
		list2.add("bb");
		list2.add("cc");
		list2.add("dd");
		
		System.out.println("list1:"+list1);

//		�󲢼�
//		list1.addAll(list2);
//		System.out.println("list1 use addall:"+list1);

//		�Ƴ�����
//		list1.removeAll(list2);
//		System.out.println("list1 use removeall:"+list1);

//		ȡ����
//		list1.retainAll(list2);
//		System.out.println("list1 use retainall:"+list1);

//		list1�Ƿ����list2������Ԫ��
//		list1.containsAll(list2);
//		System.out.println("list1 use containsall:"+list1);
		
	}
	public static void listIndex() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		
		System.out.println(list);
		//��2��λ�ò���һ������
		list.add(2,"��");
		System.out.println(list);
		
		//�Ƴ�λ��2��Ԫ��
		list.remove(2);
		System.out.println(list);
		
		//�滻λ��2��Ԫ��
		list.set(2, "����");
		System.out.println(list);
		
		//���λ��2��Ԫ��
		System.out.println(list.get(2));
		
		//����ָ��Ԫ�ص�һ�γ��ֵ�λ��,�������򷵻�-1
		int firstIndex = list.indexOf("d");
		System.out.println(firstIndex);
		
		//����ָ��Ԫ�����һ�γ��ֵ�λ��,�������򷵻�-1
		int lastIndex = list.lastIndexOf("d");
		System.out.println(lastIndex);
	}
}
