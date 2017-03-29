package cn.com.gome.ztghb.flasher.monitor.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by liuyin on 2015/7/15.
 */
public class MonitorQuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    //        if(null == context.getPreviousFireTime()){
//            return;
//        }
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        MonitorJob.doJob(jobDataMap);
    }
}
