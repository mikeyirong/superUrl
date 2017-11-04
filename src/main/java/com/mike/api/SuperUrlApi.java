package com.mike.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mike.entity.SuperUrl;
import com.mike.service.SuperUrlService;

/**
 * 
 * @author mike_yi
 * @since 2017-11-12
 * @version 1.0
 */
@RestController
public class SuperUrlApi {
	@Autowired
	private SuperUrlService superUrlService;

	/**
	 * 重定向跳转
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public void forwordUrl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String md5code = req.getRequestURI().replaceAll("/", "");
		String forwordUrl = superUrlService.selectSuperUrl(md5code);
		resp.sendRedirect("" + forwordUrl);
	}

	/**
	 * 注册一个superUrl
	 * @return md5Code
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUrl(HttpServletRequest req) {
		String account = req.getParameter("account");
		String asin = req.getParameter("asin");
		String productKeywords = req.getParameter("keywords");
		String sellerId = req.getParameter("sellerId");
		String sitecode =req.getParameter("sitecode");
		SuperUrl superUrl = new SuperUrl(account,asin,productKeywords,sellerId,sitecode);
		if(superUrlService.registerUrl(superUrl)) {
			return "http://localhost:8080/"+superUrl.getMd5Code();
		};
		return "message:eror";
	}

	/**
	 * 删除一个superUrl
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteUrl(HttpServletRequest req) {
		String md5code = req.getParameter("md5code");
		superUrlService.deleteUrl(md5code);
		return "";
	}

	/**
	 * 修改一个superUrl,注：主要修改productKeyWords
	 * 
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUrl(HttpServletRequest req) {
		String md5code = req.getParameter("md5code");
		String keywords = req.getParameter("keywords");
		superUrlService.updateUrl(md5code, keywords);
		return "{message:success}";
	}

	/**
	 * 查询对应店铺下所有superUrl
	 * 
	 * @return
	 */
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public String selectUrl() {
		String account = "";
		superUrlService.selectUrls(account);
		return "";
	}
}
