package com.cloud.util;

import org.apache.commons.codec.binary.Base64;

public class DESUtil {

	/**
	 * ���ܺ���
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String value) throws Exception
	{
		String key="";
		key=Configuration.getInstance().getValue("key");
		//System.err.println("��Կ:\t" + key);
		/*
		 * DESede Ҫ����Կ����Ϊ 112λ��168λ
		 */
		if (key.length() > 112) {
			key = key.substring(0, 112); //��ȡǰ112λ��Կ
		}else if (key.length() < 112) {
			int lengthTemp = 112 - key.length();
			int i;
			/********��Կ׷�ӵ�112λ**********/
			for(i = 0;i < lengthTemp;i++){
				key = key + 'A';
			}
		}
		byte[] jiaMiHou=DESedeCoder.encrypt(value.getBytes(), key.getBytes()); //ִ�м��ܲ���
		
		return Base64.encodeBase64String(jiaMiHou);
	}
	
	/**
	 * ���ܺ��� 
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String value)
	{
		if(value==null || "".equals(value.trim())){
			return "";
		}
		String key="";
		key=Configuration.getInstance().getValue("key");
		if (key.length() > 112) {
			key = key.substring(0, 112);
		}else if (key.length() < 112) {
			int lengthTemp = 112 - key.length();
			int i;
			for(i = 0;i < lengthTemp;i++){
				key = key + 'A';
			}
		}
		byte[] outPutStr = null;
		try {
			outPutStr = DESedeCoder.decrypt(Base64.decodeBase64(value), key.getBytes());
		} catch (Exception e) {
//			e.printStackTrace();
		} //ִ�н��ܲ���
		if(outPutStr==null)
			return "";
		return new String(outPutStr);
	}
}
