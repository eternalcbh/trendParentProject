package cn.how2j.trend.config;

import cn.how2j.trend.job.IndexDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.config
 * @ClassName:QuartzConfiguration
 * @Description:
 * @date 2020-12-16 10:11
 */
@Configuration
public class QuartzConfiguration {
	private static final int interval = 1;

	@Bean
	public JobDetail weatherDataSyncJobDetail(){
		return JobBuilder.newJob(IndexDataSyncJob.class).withIdentity("indexDataSyncJob").storeDurably().build();
	}

	@Bean
	public Trigger weatherDataSyncTrigger(){
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().
				withIntervalInHours(interval).repeatForever();

		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger").
				withSchedule(scheduleBuilder).build();
	}
}
