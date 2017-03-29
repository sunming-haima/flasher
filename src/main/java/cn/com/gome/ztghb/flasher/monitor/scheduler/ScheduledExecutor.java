package cn.com.gome.ztghb.flasher.monitor.scheduler;

import cn.com.gome.ztghb.flasher.monitor.job.MonitorExecutorJob;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyin on 2015/7/15.
 */
public class ScheduledExecutor implements ScheduledService {
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

    @Override
    public void startJob(Map<String,Object> context,int intervalInSeconds) {
        MonitorExecutorJob job = new MonitorExecutorJob(context);
        service.scheduleAtFixedRate(job,0,intervalInSeconds,TimeUnit.SECONDS);
    }

    @Override
    public void shutdown() {
        if(null != service){
            service.shutdown();
        }
        service = null;
    }

}
