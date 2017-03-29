package cn.com.gome.ztghb.flasher.monitor.protocol.falcon;

import cn.com.gome.ztghb.flasher.monitor.protocol.AbstractProtocol;
import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by liuyin on 2015/6/12.
 */
public class FalconProtocol extends AbstractProtocol {
    private String counterType = "GAUGE";
    private String tag;

    public String getCounterType() {
        return counterType;
    }

    public void setCounterType(String counterType) {
        this.counterType = counterType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public Serializable toExport() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
