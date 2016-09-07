package com.bigbird.shares.quartz;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoTask {
	private static Logger logger = LoggerFactory.getLogger(AutoTask.class);

	protected void execute() throws ParseException {
		logger.info("每天定时获取沪深股票列表");
		String url = "http://localhost:8888/shares/sharesList/updateByPrimaryKeySelective";
		for (int i = 1; i <= 1130 / 20 + 1; i++) {
			String param = "page=" + i + "&type=shall";
			NetWork.sendGet(url, param);
		}
	}

	public void auto() {
		logger.info("每天定时获取深市股票列表");
		String url = "http://localhost:8888/shares/sharesList/updateByPrimaryKeySelective";
		for (int i = 1; i <= 1843 / 20 + 1; i++) {
			String param = "page=" + i + "&type=szall";
			NetWork.sendGet(url, param);
		}
	}

//	public class MyThread implements Runnable {
//
//		@Override
//		public void run() {
//			String url = "http://localhost:8888/shares/sharesList/updateByPrimaryKeySelective";
//			for (int i = 1; i <= 1130 / 20 + 1; i++) {
//				String param = "page=" + i + "&type=shall";
//				NetWork.sendGet(url, param);
//			}
//		}
//	}
}
