package org.heng.funguava;


import com.google.common.base.Function;
import com.google.common.base.Joiner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangdi5 on 2015/5/7.
 */
public class DateFormatFunction implements Function<Date,String> {

    @Override
    public String apply(Date input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Joiner.on(",");
        return dateFormat.format(input);
        }
}
