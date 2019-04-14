package com.danhuang.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��������ȡ������
 * ���ҳ�����еĳ�����
 * �������нϺõ����������wget...
 * 
 * @author danhuang
 *
 */
public class WebSpider {
	/**
	 * ���urlString��Ӧ����ҳԴ������
	 * @param args
	 */
	public static String getURLContent(String urlStr,String charset) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charset)));
			String temp = "";
			while((temp = reader.readLine()) != null) {
				sb.append(temp);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();

	}
	
	public static List<String> getMatherSubStrs(String destStr,String regexStr){
		
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(destStr);
		List<String> result = new ArrayList<>();
		while(m.find()) {
			result.add(m.group(1));
		}
		return result;
	}
	public static void main(String[] args) {
		String destStr = getURLContent("http://www.163.com","gbk");
		//System.out.println(destStr); //��ӡҳ���Դ��
		
//		Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");//ȡ���ĳ����ӵ���������
		
		List<String> result = getMatherSubStrs(destStr, "href=\"([\\w\\s./:]+?)\"");
		for (String string : result) {
			System.out.println(string);
		}
	}
}
