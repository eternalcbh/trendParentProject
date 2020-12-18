package cn.how2j.trend.job;

import cn.how2j.trend.pojo.Index;
import cn.how2j.trend.service.IndexDataService;
import cn.how2j.trend.service.IndexService;
import cn.hutool.core.date.DateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author cbh
 * @PackageName:cn.how2j.trend.job
 * @ClassName:IndexDataSyncJob
 * @Description:任务类同时刷新指数代码和指数数据
 * @date 2020-12-16 9:00
 */
public class IndexDataSyncJob extends QuartzJobBean {

	@Autowired
	private IndexDataService indexDataService;

	@Autowired
	private IndexService indexService;

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("定时器启动了" + DateUtil.now());
		List<Index> indexes = indexService.fresh();
		for (Index index : indexes) {
			indexDataService.fresh(index.getCode());
		}
		System.out.println("定时结束" + DateUtil.now());
	}
}
