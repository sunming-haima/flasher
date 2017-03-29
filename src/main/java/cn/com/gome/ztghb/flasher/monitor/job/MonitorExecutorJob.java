package cn.com.gome.ztghb.flasher.monitor.job;

import java.util.Map;

/**
 * Created by liuyin on 2015/7/15.
 */
public class MonitorExecutorJob implements Runnable {
    private Map<String,Object> context;

    private MonitorExecutorJob(){}
    public MonitorExecutorJob(Map<String,Object> context){
        this.context = context;
    }
    @Override
    public void run() {
        MonitorJob.doJob(context);
    }
}
