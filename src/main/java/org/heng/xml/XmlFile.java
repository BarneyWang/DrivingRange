package org.heng.xml;

/**
 * Created by wangdi5 on 2015/4/28.
 */
import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XmlFile {
    String value();
}
