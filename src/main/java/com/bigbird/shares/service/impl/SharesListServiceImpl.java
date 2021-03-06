package com.bigbird.shares.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bigbird.shares.base.BaseModel;
import com.bigbird.shares.mapper.list.SharesListMapper;
import com.bigbird.shares.pojo.list.SharesList;
import com.bigbird.shares.service.SharesListService;
import com.bigbird.shares.utils.Utils;

@Service
public class SharesListServiceImpl implements SharesListService,Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -5780811290018711566L;
	private Logger logger = LoggerFactory.getLogger(SharesListServiceImpl.class);
	@Resource
	public SharesListMapper sharesListMapper;

	BaseModel baseModel = new BaseModel();

	@Override
	public int insertSharesList(String appkey, String apiUrl, int page, String type) {
		// TODO Auto-generated method stub
		SharesList sharesList = new SharesList();
		String response = null;
		int result = 0;
		String url = apiUrl + type;// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("key", appkey);// 您申请的APPKEY
		params.put("page", String.valueOf(page));// 第几页,每页20条数据,默认第1页
		try {
			response = Utils.netRequest(url, params, "GET");
			System.out.println(response);
			JSONObject responseJson = JSONObject.parseObject(response);
			JSONObject resultJson = responseJson.getJSONObject("result");
			if (responseJson.getIntValue("error_code") == 0) {
				JSONArray data = resultJson.getJSONArray("data");
				for (int i = 0; i < data.size(); i++) {
					sharesList.setSymbol(data.getJSONObject(i).getString("symbol"));
					sharesList.setName(data.getJSONObject(i).getString("name"));
					sharesList.setTrade(data.getJSONObject(i).getString("trade"));
					sharesList.setPricechange(data.getJSONObject(i).getString("pricechange"));
					sharesList.setChangepercent(data.getJSONObject(i).getString("changepercent"));
					sharesList.setBuy(data.getJSONObject(i).getString("buy"));
					sharesList.setSell(data.getJSONObject(i).getString("sell"));
					sharesList.setSettlement(data.getJSONObject(i).getString("settlement"));
					sharesList.setOpen(data.getJSONObject(i).getString("open"));
					sharesList.setHigh(data.getJSONObject(i).getString("high"));
					sharesList.setLow(data.getJSONObject(i).getString("low"));
					sharesList.setVolume(data.getJSONObject(i).getString("volume"));
					sharesList.setAmount(data.getJSONObject(i).getString("amount"));
					sharesList.setCode(data.getJSONObject(i).getString("symbol").substring(2));
					sharesList.setTicktime(data.getJSONObject(i).getString("ticktime"));
					result = this.sharesListMapper.insertSelective(sharesList);
				}
				logger.info("保存成功");
			} else {
				logger.error(responseJson.get("error_code") + ":" + responseJson.get("reason"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public BaseModel querySharesListByCode(String appkey, String apiUrl, String code) {
		SharesList sharesList = new SharesList();
		sharesList = sharesListMapper.selectByCode(code);
		String response = null;
		String url = apiUrl;// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
	
		params.put("gid", sharesList.getSymbol());
		params.put("key", appkey);// 您申请的APPKEY
		try {
			response = Utils.netRequest(url, params, "GET");
			System.out.println(response);
			JSONObject responseJson = JSONObject.parseObject(response);
			if (responseJson.getIntValue("error_code") == 0) {
				JSONArray resultJson = responseJson.getJSONArray("result");
				baseModel.setData(resultJson);
				baseModel.setResult("success");
				baseModel.setSuccess("true");
				logger.info("保存成功");
			} else {
				logger.error(responseJson.get("error_code") + ":" + responseJson.get("reason"));
				baseModel.setData(responseJson.get("reason"));
				baseModel.setResult("success");
				baseModel.setSuccess("false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseModel;
	}

	@Override
	public int updateByPrimaryKeySelective(String appkey, String apiUrl, int page, String type) {
		SharesList sharesList = new SharesList();
		String response = null;
		int result = 0;
		String url = apiUrl + type;// 请求接口地址
		Map<String, String> params = new HashMap<String, String>();// 请求参数
		params.put("key", appkey);// 您申请的APPKEY
		params.put("page", String.valueOf(page));// 第几页,每页20条数据,默认第1页
		try {
			response = Utils.netRequest(url, params, "GET");
			System.out.println(response);
			JSONObject responseJson = JSONObject.parseObject(response);
			JSONObject resultJson = responseJson.getJSONObject("result");
			if (responseJson.getIntValue("error_code") == 0) {
				JSONArray data = resultJson.getJSONArray("data");
				for (int i = 0; i < data.size(); i++) {
					sharesList.setSymbol(data.getJSONObject(i).getString("symbol"));
					sharesList.setName(data.getJSONObject(i).getString("name"));
					sharesList.setTrade(data.getJSONObject(i).getString("trade"));
					sharesList.setPricechange(data.getJSONObject(i).getString("pricechange"));
					sharesList.setChangepercent(data.getJSONObject(i).getString("changepercent"));
					sharesList.setBuy(data.getJSONObject(i).getString("buy"));
					sharesList.setSell(data.getJSONObject(i).getString("sell"));
					sharesList.setSettlement(data.getJSONObject(i).getString("settlement"));
					sharesList.setOpen(data.getJSONObject(i).getString("open"));
					sharesList.setHigh(data.getJSONObject(i).getString("high"));
					sharesList.setLow(data.getJSONObject(i).getString("low"));
					sharesList.setVolume(data.getJSONObject(i).getString("volume"));
					sharesList.setAmount(data.getJSONObject(i).getString("amount"));
					sharesList.setCode(data.getJSONObject(i).getString("symbol").substring(2));
					sharesList.setTicktime(data.getJSONObject(i).getString("ticktime"));
					result = sharesListMapper.updateByPrimaryKeySelective(sharesList);
				}
				logger.info("保存成功");
			} else {
				logger.error(responseJson.get("error_code") + ":" + responseJson.get("reason"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
