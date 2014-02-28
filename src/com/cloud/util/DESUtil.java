package com.cloud.util;

import org.apache.commons.codec.binary.Base64;

public class DESUtil {

	/**
	 * 加密函数
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String value) throws Exception
	{
		String key="";
		key=Configuration.getInstance().getValue("key");
		//System.err.println("密钥:\t" + key);
		/*
		 * DESede 要求密钥长度为 112位或168位
		 */
		if (key.length() > 112) {
			key = key.substring(0, 112); //截取前112位密钥
		}else if (key.length() < 112) {
			int lengthTemp = 112 - key.length();
			int i;
			/********密钥追加到112位**********/
			for(i = 0;i < lengthTemp;i++){
				key = key + 'A';
			}
		}
		byte[] jiaMiHou=DESedeCoder.encrypt(value.getBytes(), key.getBytes()); //执行加密操作
		
		return Base64.encodeBase64String(jiaMiHou);
	}
	
	/**
	 * 解密函数 
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
		} //执行解密操作
		if(outPutStr==null)
			return "";
		return new String(outPutStr);
	}
}
