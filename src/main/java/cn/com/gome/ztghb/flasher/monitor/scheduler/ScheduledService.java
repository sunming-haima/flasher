package cn.com.gome.ztghb.flasher.monitor.scheduler;

import java.util.Map;

/**
 * Created by liuyin on 2015/7/15.
 */
public interface ScheduledService {
    void startJob(Map<String, Object> context, int intervalInSeconds);
    void shutdown();
}
