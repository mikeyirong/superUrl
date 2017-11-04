package com.mike;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Test {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String sss=System.currentTimeMillis()+"";
		MessageDigest md5=MessageDigest.getInstance("MD5");
	    BASE64Encoder base64en = new BASE64Encoder();
	    String cdc=base64en.encode(md5.digest(sss.getBytes("utf-8")));
	    System.out.println(cdc.replaceAll("/", ""));
	}
}
