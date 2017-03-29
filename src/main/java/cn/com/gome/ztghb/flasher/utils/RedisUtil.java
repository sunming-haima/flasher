package cn.com.gome.ztghb.flasher.utils;

import cn.com.gome.ztghb.flasher.Constants;

/**
 * Created by liuyin on 2015/6/29.
 */
public class RedisUtil {

    public static String buildKey(String business,String key){
        return new StringBuilder(business).append(Constants.DEFAULT_SEPARATOR).append(key).toString();
    }

    public static String buildKeys(String business,String ... keys){
        StringBuilder sb = new StringBuilder(business).append(Constants.DEFAULT_SEPARATOR);
        for(String key : keys){
            sb.append(key);
        }
        return sb.toString();
    }


}
