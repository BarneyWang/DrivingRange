package org.heng.xml;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.InputStream;

/**
 * Created by wangdi5 on 2015/4/28.
 */
public class ConfigManager {


        public static <T> T getConfig(Class<T> clazz) {
            XmlFile anno = clazz.getAnnotation(XmlFile.class);
            if (anno == null) {
                throw new IllegalStateException();
            }
            Serializer serializer = new Persister();
            InputStream is = ConfigManager.class.getResourceAsStream("/" + EnvConfig.get() + "/" + anno.value());
            try {
                T config = serializer.read(clazz, is);
                return config;
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }


}
