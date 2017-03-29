package cn.com.gome.ztghb.flasher.impl;

import cn.com.gome.ztghb.flasher.Command;
import cn.com.gome.ztghb.flasher.IRedis;
import cn.com.gome.ztghb.flasher.enums.ExistEnum;
import cn.com.gome.ztghb.flasher.enums.ExpireTimeEnum;
import cn.com.gome.ztghb.flasher.spring.IRedisConnection;
import cn.com.gome.ztghb.flasher.utils.RedisUtil;
import com.google.common.base.Strings;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuyin on 2015/6/29.
 */
public class RedisImpl implements IRedis {
    private IRedisConnection redisConnectionFactory;
    private RedisImpl(){}

    public RedisImpl(IRedisConnection redisConnectionFactory){
        this.redisConnectionFactory = redisConnectionFactory;
    }

    public IRedisConnection getRedisConnectionFactory() {
        return redisConnectionFactory;
    }
    public void setRedisConnectionFactory(IRedisConnection redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Override
    public String hget(String business, String key, String field) {
        return getJedis().hget(RedisUtil.buildKey(getBusiness(business), key), field);
    }

    @Override
    public Map<String, String> hgetAll(String business, String key) {
        return getJedis().hgetAll(RedisUtil.buildKey(getBusiness(business), key));
    }

    @Override
    public Long expire(String business, String key, int seconds) {
        return getJedis().expire(RedisUtil.buildKey(getBusiness(business), key), seconds);
    }

    @Override
    public Long expireAt(String business, String key, long unixTime) {
        return getJedis().expireAt(RedisUtil.buildKey(getBusiness(business), key), unixTime);
    }

    @Override
    public Long ttl(String business, String key) {
        return getJedis().ttl(RedisUtil.buildKey(getBusiness(business), key));
    }

    @Override
    public Long decrBy(String business, String key, long integer) {
        return getJedis().decrBy(RedisUtil.buildKey(getBusiness(business), key), integer);
    }

    @Override
    public Long decr(String business, String key) {
        return getJedis().decr(RedisUtil.buildKey(getBusiness(business), key));
    }

    @Override
    public Long incrBy(String business, String key, long integer) {
        return getJedis().incrBy(RedisUtil.buildKey(getBusiness(business), key), integer);
    }

    @Override
    public Long incr(String business, String key) {
        return getJedis().incr(RedisUtil.buildKey(getBusiness(business), key));
    }

    @Override
    public Long hset(String business, String key, String field, String value) {
        return getJedis().hset(RedisUtil.buildKey(getBusiness(business), key), field, value);
    }

    @Override
    public String set(String business, String key, String value) {
        return getJedis().set(RedisUtil.buildKey(getBusiness(business), key), value);
    }

    @Override
    public String get(String business, String key) {
        return getJedis().get(RedisUtil.buildKey(getBusiness(business), key));
    }

    @Override
    public Boolean exists(String business, String key) {
        return getJedis().exists(RedisUtil.buildKey(getBusiness(business), key));
    }

    @Override
    public String type(String business, String key) {
        return getJedis().type(RedisUtil.buildKey(getBusiness(business), key));
    }

    @Override
    public Long append(String business, String key, String value) {
        return getJedis().append(RedisUtil.buildKey(getBusiness(business), key), value);
    }

    @Override
    public String substr(String business, String key, int start, int end) {
        return getJedis().substr(RedisUtil.buildKey(getBusiness(business), key), start, end);
    }

    @Override
    public Long hsetnx(String business, String key, String field, String value) {
        return getJedis().hsetnx(RedisUtil.buildKey(getBusiness(business), key), field, value);
    }

    @Override
    public String hmset(String business, String key, Map<String, String> hash) {
        return getJedis().hmset(RedisUtil.buildKey(getBusiness(business), key), hash);
    }

    @Override
    public List<String> hmget(String business, String key, String... fields) {
        return getJedis().hmget(RedisUtil.buildKey(getBusiness(business), key), fields);
    }

    @Override
    public Long hincrBy(String business, String key, String field, long value) {
        return getJedis().hincrBy(RedisUtil.buildKey(getBusiness(business), key), field, value);
    }

    @Override
    public Boolean hexists(String business, String key, String field) {
        return getJedis().hexists(RedisUtil.buildKey(getBusiness(business), key), field);
    }

    @Override
    public Long hdel(String business, String key, String... field) {
        return getJedis().hdel(RedisUtil.buildKey(getBusiness(business), key), field);
    }

    @Override
    public Long hlen(String business, String key) {
        return getJedis().hlen(RedisUtil.buildKey(getBusiness(business),key));
    }

    @Override
    public Set<String> hkeys(String business, String key) {
        return getJedis().hkeys(RedisUtil.buildKey(getBusiness(business),key));
    }

    @Override
    public List<Object> mutliExecute(String business, List<Command> commands) {
        return null;
    }

    @Override
    public long del(String business, String... keys) {
        return getJedis().del(RedisUtil.buildKeys(getBusiness(business), keys));
    }

    @Override
    public Long llen(String business, String key) {
        return getJedis().llen(RedisUtil.buildKey(getBusiness(business),key));
    }

    @Override
    public String lpop(String business, String key) {
        return getJedis().lpop(RedisUtil.buildKey(getBusiness(business),key));
    }

    @Override
    public Long lpush(String business, String key, String... values) {
        return getJedis().lpush(RedisUtil.buildKey(getBusiness(business),key),values);
    }

    @Override
    public Long lrem(String business, String key, Long count, String value) {
        return getJedis().lrem(RedisUtil.buildKey(getBusiness(business),key),count,value);
    }

    @Override
    public List<String> lrange(String business, String key, Long start, Long end) {
        return getJedis().lrange(RedisUtil.buildKey(getBusiness(business),key),start,end);
    }

    @Override
    public String lindex(String business, String key, Long index) {
        return getJedis().lindex(RedisUtil.buildKey(getBusiness(business),key),index);
    }

    @Override
    public String rpop(String business, String key) {
        return getJedis().rpop(RedisUtil.buildKey(getBusiness(business),key));
    }

    @Override
    public Long rpush(String business, String key, String... values) {
        return getJedis().rpush(RedisUtil.buildKey(getBusiness(business), key), values);
    }

    @Override
    public Long sadd(String business, String key, String... values) {
        return getJedis().sadd(RedisUtil.buildKey(getBusiness(business),key),values);
    }

    @Override
    public Long scard(String business, String key) {
        return getJedis().scard(RedisUtil.buildKey(getBusiness(business),key));
    }

    @Override
    public String setex(String business, String key, Integer seconds, String value) {
        return getJedis().setex(RedisUtil.buildKey(getBusiness(business),key),seconds,value);
    }

    @Override
    public Set<String> smembers(String business, String key) {
        return getJedis().smembers(RedisUtil.buildKey(getBusiness(business),key));
    }

    @Override
    public Long srem(String business, String key, String... values) {
        return getJedis().srem(RedisUtil.buildKey(getBusiness(business),key),values);
    }

    @Override
    public String ltrim(String business, String key, Long start, Long end) {
        return getJedis().ltrim(RedisUtil.buildKey(getBusiness(business),key),start,end);
    }

    @Override
    public String set(String business, String key, String value, ExistEnum existEnum, ExpireTimeEnum expireTimeEnum, long time) {
        return getJedis().set(RedisUtil.buildKey(getBusiness(business),key),value,existEnum.name(),existEnum.name(),time);
    }

    @Override
    public String getSet(String business, String key, String value) {
        return getJedis().getSet(RedisUtil.buildKey(getBusiness(business),key),value);
    }


    private String getBusiness(String business){
        if(Strings.isNullOrEmpty(getRedisConnectionFactory().getBusiness())){
            return business;
        } else {
            return getRedisConnectionFactory().getBusiness();
        }
    }

    private Jedis getJedis(){
        return getRedisConnectionFactory().getJedis();
    }
}
