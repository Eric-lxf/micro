package com.micro.mi.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.StringUtils;

/**
 * SHA加密工具类
 * @author xifeng.liu
 *
 */
public class SHA {

	/**定义加密方式**/
	private static final String  KEY_SHA = "SHA";
	private static final String  KEY_SHA1 = "SHA-1";
	/**定义全局数组**/
	private static final String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"}; 
	public SHA(){}
	/**
	 * 字节数组sha简单加密
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] encryptSHA(byte[] data) throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA1);
		messageDigest.update(data);
		return messageDigest.digest();
	}
	/**
	 * 字符串sha加密
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptSHA(String data) throws NoSuchAlgorithmException{
		if(StringUtils.isEmpty(data)){
			return "";
		}
		MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
		messageDigest.update(data.getBytes());
		byte[] bytes = messageDigest.digest();
		return byteArrayToHexString(bytes);
	}

	private static String byteArrayToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<bytes.length -1;i++){
			sb.append(byteToHexString(bytes[i]));
		}
		return sb.toString();
	}

	private static String byteToHexString(byte b) {
		int ret = b;
		if(ret < 0 ){
			ret += 256;
		}
		int m = ret / 16;
		int n = ret % 16;
		return hexDigits[m] + hexDigits[n];
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		System.out.println(encryptSHA("111111"));
	}
}
