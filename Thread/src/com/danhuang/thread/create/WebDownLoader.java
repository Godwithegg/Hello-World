package com.danhuang.thread.create;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * ����ͼƬ
 * @author danhuang
 *
 */
public class WebDownLoader {
	/**
	 * ����
	 * @param url
	 * @param name
	 */
	public void downLoad(String url,String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("���Ϸ���url");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}

}
