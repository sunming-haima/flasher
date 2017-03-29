package cn.com.gome.ztghb.flasher.monitor.protocol;

import java.io.Serializable;

/**
 * Created by liuyin on 2015/6/12.
 */
public interface Protocol extends Serializable {
    /**
     * 传输数据的统一格式化输出
     * @return
     */
    Serializable toExport();
}
