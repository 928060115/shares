package com.bigbird.shares.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigbird.shares.service.SharesListService;

@Controller
@RequestMapping(value="/sharesList")
public class SharesListAction {
	
	@Resource
	private SharesListService sharesListService;
	
	@RequestMapping(value="/insertSharesList", method = RequestMethod.GET)
	@ResponseBody
	public int queryFundInfoByFundCode(HttpServletRequest request,HttpServletResponse response,int page,String type) throws Exception {
		return sharesListService.insertSharesList(page, type);
	}
}
