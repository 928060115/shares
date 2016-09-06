package com.bigbird.shares.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigbird.shares.base.BaseModel;
import com.bigbird.shares.service.SharesListService;

@Controller
@RequestMapping(value="/sharesList")
public class SharesListAction {
	
	@Resource
	private SharesListService sharesListService;
	
	
	@RequestMapping(value="/insertSharesList", method = RequestMethod.GET)
	@ResponseBody
	public int insertSharesList(HttpServletRequest request,HttpServletResponse response,int page,String type) throws Exception {
		String appkey = request.getServletContext().getAttribute("APPKEY").toString();
		String apiUrl = request.getServletContext().getAttribute("apiUrl").toString();
		return sharesListService.insertSharesList(appkey,apiUrl,page, type);
	}
	
	@RequestMapping(value="/querySharesList", method = RequestMethod.GET)
	@ResponseBody
	public BaseModel querySharesList(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		return sharesListService.querySharesListByCode(code);
	}
	
	@RequestMapping(value="/updateByPrimaryKeySelective", method = RequestMethod.GET)
	@ResponseBody
	public int updateByPrimaryKeySelective(HttpServletRequest request,HttpServletResponse response,int page,String type) throws Exception {
		String appkey = request.getServletContext().getAttribute("APPKEY").toString();
		String apiUrl = request.getServletContext().getAttribute("apiUrl").toString();
		return sharesListService.updateByPrimaryKeySelective(appkey,apiUrl,page, type);
	}
}
