package com.mike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mike.dao.SuperUrlDao;
import com.mike.entity.SuperUrl;
/**
 * @author mike_yi
 * @since 2017-11-2
 * @version 1.0
 */
@Service
public class SuperUrlService {
	@Autowired
	private SuperUrlDao superUrlDao;
	/**
	 * @param md5code
	 * @return
	 */
	public String selectSuperUrl(String md5code) {
		SuperUrl superUrl = superUrlDao.selectUrlByMd5code(md5code);
		if(superUrl!=null) {
			String originUrl =superUrl.getOriginUrl();
			//更新点击次数
			superUrl.setClickNum(superUrl.getClickNum()+1);
			superUrlDao.updateClickNum(superUrl);
			return originUrl;
		}else {
			return "https://www.amazon.com/";
		}
	}
	/**
	 * 
	 * @param superUrl
	 * @return
	 */
	public boolean registerUrl(SuperUrl superUrl) {
        return superUrlDao.addSuperUrl(superUrl);
	}
	/**
	 * 
	 * @param md5Code
	 * @return
	 */
	public boolean deleteUrl(String md5Code) {
		return superUrlDao.deleteUrl(md5Code);
	}
     /**
      * 
      * @param md5code
      * @param productKeywords
      */
	public void updateUrl(String md5code,String productKeywords) {
		superUrlDao.updateUrl(md5code,productKeywords);
	}

	public List<SuperUrl> selectUrls(String account) {
         return superUrlDao.selectUrls(account);
	}

}
