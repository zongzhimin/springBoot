package com.zzm.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
//	@Scheduled(fixedDelay = 5000)
//	@Scheduled(initialDelay=1000, fixedRate=5000)
//	@Scheduled(cron="*/5 * * * * *")
	public void reportCurrentTime(){
		System.out.println("现在时间："+dateFormat.format(new Date()));
	}
}
