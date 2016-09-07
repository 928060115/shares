package com.bigbird.shares.service;

import com.bigbird.shares.base.BaseModel;

public interface SharesListService {
	
	public int insertSharesList(String appkey,String apiUrl,int page,String type);
	
	public BaseModel querySharesListByCode(String appkey,String apiUrl,String code);
	
	public int updateByPrimaryKeySelective(String appkey,String apiUrl,int page,String type);
}
