package org.heng.xml.impl.cache;


import com.google.gson.Gson;
import org.heng.xml.XmlFile;
import org.simpleframework.xml.Element;

/**
 * @author wangdi
 */
@XmlFile("cache.xml")
public class CacheConfig {

    @Element
    private String host;

    @Element
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
