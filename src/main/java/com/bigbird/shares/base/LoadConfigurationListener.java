package com.bigbird.shares.base;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: LoadConfigurationListener
 * @Description: �������������ļ�
 * @author: liuyang
 * @date: 2016��9��5�� ����3:45:14
 */
public class LoadConfigurationListener implements ServletContextListener {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	public static final String configFile = "/config.properties";

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
		PropertiesConfiguration authConfig;
		try {
			authConfig = new PropertiesConfiguration(configFile);
			authConfig.setEncoding("utf-8");
			authConfig.load();
			event.getServletContext().setAttribute("APPKEY", authConfig.getString("APPKEY"));
			event.getServletContext().setAttribute("apiUrl", authConfig.getString("apiUrl"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
