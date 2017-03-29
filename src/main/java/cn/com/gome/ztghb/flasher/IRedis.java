package cn.com.gome.ztghb.flasher;

import cn.com.gome.ztghb.flasher.enums.ExistEnum;
import cn.com.gome.ztghb.flasher.enums.ExpireTimeEnum;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by christLiu on 2015/4/21.
 */
public interface IRedis {
    String hget(String business, String key, String field);
    Map<String, String> hgetAll(String business, String key);
    Long expire(String business, String key, int seconds);
    Long expireAt(String business, String key, long unixTime);
    Long ttl(String business, String key);
    Long decrBy(String business, String key, long integer);
    Long decr(String business, String key);
    Long incrBy(String business, String key, long integer);
    Long incr(String business, String key);
    Long hset(String business, String key, String field, String value);
    String set(String business, String key, String value);
    String get(String business, String key);
    Boolean exists(String business, String key);
    String type(String business, String key);
    Long append(String business, String key, String value);
    String substr(String business, String key, int start, int end);
    Long hsetnx(String business, String key, String field, String value);
    String hmset(String business, String key, Map<String, String> hash);
    List<String> hmget(String business, String key, String... fields);
    Long hincrBy(String business, String key, String field, long value);
    Boolean hexists(String business, String key, String field);
    Long hdel(String business, String key, String... field);
    Long hlen(String business, String key);
    Set<String> hkeys(String business, String key);

    /**
     * 批量执行redis服务操作
     * @param business
     * @param commands Command 参见 @link Command
     * @return
     *
     * 注意：Command中，若采用属性set则：
     *          business 可选，目前与business相同 参见 @link CommandTypeEnum
     *          commandName 必需，RedisClusterImpl的方法枚举名称
     *          parameters 必需，方法参数集合，此处若方法参数包括business，则business参数一定不要，即此集合包括调用方法除business的参数。
     *      若采用Command(CommandTypeEnum commandName, Object... coms)构造则：
     *          commandName 必需，RedisClusterImpl的方法枚举名称
     *          coms 方法参数集合，必须与所调用的方法参数个数及类型相同，此处若方法参数包括business，则business参数一定不要，即此集合包括调用方法除business的参数。
     */
    List<Object> mutliExecute(String business, List<Command> commands);
    long del(String business, String... keys);
    Long llen(String business, String key);
    String lpop(String business, String key);
    Long lpush(String business, String key, String... values);
    Long lrem(String business, String key, Long count, String value);
    List<String> lrange(String business, String key, Long start, Long end);
    String lindex(String business, String key, Long index);
    String rpop(String business, String key);
    Long rpush(String business, String key, String... values);
    Long sadd(String business, String key, String... values);
    Long scard(String business, String key);
    String setex(String business, String key, Integer seconds, String value);
    Set<String> smembers(String business, String key);
    Long srem(String business, String key, String... values);
    String ltrim(String business, String key, Long start, Long end);


    String set(String business, String key, String value, ExistEnum existEnum, ExpireTimeEnum expireTimeEnum, long time);
    String getSet(String business, String key, String value);

}
