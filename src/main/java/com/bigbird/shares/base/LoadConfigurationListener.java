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
 * @Description: �������������ļ�
 * @author: liuyang
 * @date: 2016��9��5�� ����3:45:14
 */
public class LoadConfigurationListener implements ServletContextListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	public static final String configFile = "/config.propertis";

	@Override
	// ʵ�����е����ٺ���
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		logger.debug("���������٣�ϵͳֹͣ...");
	}

	@Override
	// ʵ�����еĳ�ʼ�������������¼�����ʱ������
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		logger.debug("loadConfiguration...");
		// -------------------------------Ȩ�������ļ�
		PropertiesConfiguration authConfig = new PropertiesConfiguration();
		authConfig.setEncoding("utf-8");
		authConfig.setURL(ConfigureUtil.class.getResource(configFile));
		authConfig.setReloadingStrategy(new FileChangedReloadingStrategy());
		ConfigurationUtils.dump(authConfig, System.out);
		event.getServletContext().setAttribute("APPKEY", authConfig.getStringArray("APPKEY"));
		event.getServletContext().setAttribute("apiUrl", authConfig.getStringArray("apiUrl"));
	}

}
