package cn.com.gome.ztghb.flasher.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.Jedis;

/**
 * Created by liuyin on 2015/6/29.
 */
public interface IRedisConnection extends InitializingBean, DisposableBean {
    Jedis getJedis();

    String getBusiness();
}
