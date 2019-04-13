package com.danhuang.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import sun.misc.IOUtils;

/**
 * �����������
 * @author danhuang
 *
 */
public class NetClassLoader extends ClassLoader{
	
	private String rootUrl;
	public NetClassLoader(String rootUrl) {
		this.rootUrl = rootUrl;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		// Ӧ��Ҫ�Ȳ�ѯ��û�м��ع�����࣬����Ѿ������أ���ֱ�ӷ��ؼ��غõ��ࡣ����У�������µ���
		if (c != null) {
			return c;
		} else {
			ClassLoader parent = this.getParent();// ��ø��������
			parent.loadClass(name);// ����ȥ����
			if (c != null) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if (classData == null) {
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
				}
			}
		}
		return c;
	}

	private byte[] getClassData(String classname) {// com.danhuang.jvm.User --> D:/github/javalearning/javalearing/JVM/ com/danhuang/jvm/User.class
		String path = rootUrl + "/" + classname.replace('.', '/') + ".class";
		// IOUtils,����ʹ���������е�����ת���ֽ�����
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		try {
			URL url = new URL(path); 
			is = url.openStream();
			int temp = 0;
			while ((temp = is.read(buffer)) != -1) {
				baos.write(buffer, 0, temp);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
