package cn.com.gome.ztghb.flasher.enums;

/**
 * Created by christLiu on 2015/4/21.
 */
public enum CommandTypeEnum {
    hget, hgetAll, expire, expireAt, ttl, //
    decrBy, decr, incrBy, incr, hset, //
    set, get, exists, type, append, //
    substr, hsetnx, hmset, hmget, hincrBy, //
    hexists, hdel, hlen, hkeys, keys, //
    dbSize, del, setex, //
    // list
    rpush, lpush, llen, lrange, //
    lindex, lpop, rpop, ltrim, //
    lrem,
    // set
    sadd, srem, scard, smembers;//
}
