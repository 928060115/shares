package com.bigbird.shares.base;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hjb.common.util.ConfigureUtil;
import com.hjb.common.util.Util;

/**
 * @ClassName: LoadConfigurationListener
 * @Description: 启动加载配置文件
 * @author: liuyang
 * @date: 2016年9月5日 下午3:45:14
 */
public class LoadConfigurationListener implements ServletContextListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	public static final String configFile = "/config.propertis";

	@Override
	// 实现其中的销毁函数
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		logger.debug("上下文销毁，系统停止...");
	}

	@Override
	// 实现其中的初始化函数，当有事件发生时即触发
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		logger.debug("loadConfiguration...");
		// -------------------------------权限配置文件
		PropertiesConfiguration authConfig = new PropertiesConfiguration();
		authConfig.setEncoding("utf-8");
		authConfig.setURL(ConfigureUtil.class.getResource(configFile));
		authConfig.setReloadingStrategy(new FileChangedReloadingStrategy());
		ConfigurationUtils.dump(authConfig, System.out);
		event.getServletContext().setAttribute("APPKEY", authConfig.getStringArray("APPKEY"));
		event.getServletContext().setAttribute("apiUrl", authConfig.getStringArray("apiUrl"));
	}

}
