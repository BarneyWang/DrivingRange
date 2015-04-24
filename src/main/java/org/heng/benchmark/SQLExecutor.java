package org.heng.benchmark;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangdi5 on 2015/4/9.
 */
public abstract  class SQLExecutor {


    private final String name;

    public SQLExecutor(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Connection getConnection() throws SQLException;
}
