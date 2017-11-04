package com.mike.entity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import sun.misc.BASE64Encoder;

/**
 * 
 * @author mike_yi
 * @since 2017-11-2
 * @version 1.0
 *
 */
public class SuperUrl {
	/**
	 * 账号
	 */
	String account;
	/**
	 * 站点码
	 */
	String siteCode;
	/**
	 * asin
	 */
	String asin;
	/**
	 * 卖家id
	 */
	String sellerId;
	/**
	 * md5code
	 */
	String md5Code;
	/**
	 * 产品关键字
	 */
	String productKeywords;
	/**
	 * 被点击次数
	 */
    int clickNum;
    
	public SuperUrl() {

	}

	public SuperUrl(String account, String asin, String productKeywords, String sellerId, String siteCode) {
		this.account = account;
		this.asin = asin;
		this.productKeywords = productKeywords;
		this.sellerId = sellerId;
		this.siteCode = siteCode;
		this.md5Code = getSecretcode();
	}

	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getMd5Code() {
		return md5Code;
	}

	public void setMd5Code(String md5Code) {
		this.md5Code = md5Code;
	}

	public String getProductKeywords() {
		return productKeywords;
	}

	public void setProductKeywords(String productKeywords) {
		this.productKeywords = productKeywords;
	}
    
	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	/**
	 * 生成原生地址
	 * 
	 * @return
	 */
	public String getOriginUrl() {
		return "https://www.amazon." + this.siteCode + "/gp/product/" + this.asin + "?ie=UTF8&qid="
				+ System.currentTimeMillis()+"&keywords="+this.productKeywords+"&m="+this.sellerId;
	}
	/**
	 * 生成唯一短码
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * 
	 */
	public String getSecretcode() {
		String code = "";
		try {
			String sss = System.currentTimeMillis() + this.asin;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			code = base64en.encode(md5.digest(sss.getBytes("utf-8")));
		} catch (Exception e) {
			return UUID.randomUUID().toString().replaceAll("/", "").substring(0, 10);
		}
		return code.replaceAll("/", "").substring(0, 10);
	}

	@Override
	public String toString() {
		return "SuperUrl [account=" + account + ", siteCode=" + siteCode + ", asin=" + asin + ", sellerId=" + sellerId
				+ ", md5Code=" + md5Code + ", productKeywords=" + productKeywords + ", clickNum=" + clickNum + "]";
	}
}
