package com.cloud.util;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * DESede
 * 
 * @author 
 * @version 1.0
 */
public abstract class DESedeCoder {

	/**
	 * ��Կ�㷨
	 */
	public static final String KEY_ALGORITHM = "DESede";

	/**
	 * ����/�����㷨 / ����ģʽ / ��䷽ʽ
	 * Java 6֧��PKCS5PADDING��䷽ʽ
	 * Bouncy Castle֧��PKCS7Padding��䷽ʽ
	 */
	public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

	/**
	 * ת����Կ
	 * 
	 * @param key��������Կ
	 *           
	 * @return Key ��Կ
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {

		// ʵ����DES��Կ����
		DESedeKeySpec dks = new DESedeKeySpec(key);
		
		// ʵ����������Կ����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		
		// ����������Կ
		SecretKey secretKey = keyFactory.generateSecret(dks);

		return secretKey;
	}

	/**
	 * ����
	 * 
	 * @param data ����������
	 * @param key ��Կ
	 * @return byte[] ��������
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {

		// ��ԭ��Կ
		Key k = toKey(key);

		/* 
		 * ʵ����
		 * ʹ��PKCS5Padding��䷽ʽ
		 * Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		
		// ��ʼ��������Ϊ����ģʽ
		cipher.init(Cipher.DECRYPT_MODE, k);

		// ִ�н��ܲ���
		return cipher.doFinal(data);
	}

	/**
	 * ����
	 * 
	 * @param data ����������
	 * @param key ��Կ
	 * @return byte[] ��������
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {

		// ��ԭ��Կ
		Key k = toKey(key);

		/* 
		 * ʵ����
		 * ʹ��PKCS5Padding��䷽ʽ
		 * Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		 */
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

		// ��ʼ��������Ϊ����ģʽ
		cipher.init(Cipher.ENCRYPT_MODE, k);

		//getKey();
		// ִ�м��ܲ���
		return cipher.doFinal(data);
	}
	
	/**
	 * ������Կ
	 * 
	 * @return byte[] ��������Կ
	 * @throws Exception
	 */
//	public static byte[] initKey() throws Exception {
//
//		// ʵ����
//		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
//
//		/*
//		 * DESede Ҫ����Կ����Ϊ 112λ��168λ
//		 */
//		kg.init(112);
//
//		// ����������Կ
//		SecretKey secretKey = kg.generateKey();
		
//		FileOutputStream fos = new FileOutputStream("D:/DesKey.xml");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(secretKey);
//		oos.close();
		
		// �����Կ�Ķ����Ʊ�����ʽ
//		return secretKey.getEncoded();
//	}
}
