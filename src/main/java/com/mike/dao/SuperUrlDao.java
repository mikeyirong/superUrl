package com.mike.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.mike.entity.SuperUrl;

/**
 * @author mike_yi
 * @since 2017-11-3
 * @version 1.0
 */
@Component
public class SuperUrlDao {
	private final SqlSession sqlSession;
	
	public SuperUrlDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public SuperUrl selectUrlByMd5code(String md5code) {
		SuperUrl superUrl=sqlSession.selectOne("selectUrlByMd5code", md5code);
		return superUrl;
	}
	public boolean addSuperUrl(SuperUrl superUrl) {
		sqlSession.insert("addUrl", superUrl);
		return true;
	}

	public boolean deleteUrl(String md5Code) {
		sqlSession.delete("deleteByMd5", md5Code);
		return true;
	}

	public boolean updateUrl(String md5code, String productKeywords) {
		return true;
	}
    /**
     * 查找对应账号下所有 superUrl
     * @param account
     * @return
     */
	public List<SuperUrl> selectUrls(String account) {
		return null;
	}
	/**
	 * 更新superUrl被点击的次数
	 */
	public void updateClickNum(SuperUrl superUrl) {
		System.out.println(superUrl.toString());
		sqlSession.update("updateClickNum", superUrl);
	}
}
