package com.mike.mapper;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mike.entity.SuperUrl;
/**
 * @author mike_yi
 * @since 2017-11-3
 * @version 1.0
 */
@Repository
public interface SuperUrlMapper {
	public List<SuperUrl> selectByAcount();
	public void addUrl(SuperUrl superUrl) ;
	public void deleteByMd5(String Md5code);
	public void updateUrl(String md5code, String productKeywords) throws SQLException;
	public SuperUrl selectUrlByMd5code(String md5code);
	public void updateClickNum(SuperUrl superUrl);
}
