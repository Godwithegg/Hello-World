package com.danhuang.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import sun.misc.IOUtils;

/**
 * �Զ����ļ�ϵͳ�������
 * ���м̳�ClassLoader����û����дgetSystemClassLoader���������������
 * ͨ��getSystemClassLoader�����õ���AppClassloader����ͬһ��AppClassloaderʵ�������Ƶ���ģʽ��
 * ���ۣ���������ͨ������˫��ί��ģʽ������������ص�classpath�µĺ�ext�µ��������ڷ���������ͬһ���࣬���е�Classʵ��Ҳ��ͬһ����
 * @author danhuang
 *
 */
public class FileSystemClassLoader extends ClassLoader{
	
	//com.danhuang.jvm.User --> D:/github/javalearning/javalearing/JVM/ com/danhuang/jvm/User.class
	//�Ժ������ļ���������D:/github/javalearning/javalearing/JVM/�������
	private String rootDir;
	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		// Ӧ��Ҫ�Ȳ�ѯ��û�м��ع�����࣬����Ѿ������أ���ֱ�ӷ��ؼ��غõ��ࡣ����У�������µ���
		if (c != null) {
			return c;
		} else {
			try {
				ClassLoader parent = this.getParent();// ��ø��������
				parent.loadClass(name);// ����ȥ����
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
		String path = rootDir + "/" + classname.replace('.', '/') + ".class";
		// IOUtils,����ʹ���������е�����ת���ֽ�����
		InputStream is = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		try {
			is = new FileInputStream(path);
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
