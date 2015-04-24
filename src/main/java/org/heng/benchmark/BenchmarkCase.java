package org.heng.benchmark;

/**
 * Created by wangdi5 on 2015/4/9.
 */
public abstract class BenchmarkCase {

    private final String name;

    public BenchmarkCase(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUp(SQLExecutor sqlExec) throws Exception {

    }

    public abstract void execute(SQLExecutor sqlExec) throws Exception;

    public void tearDown(SQLExecutor sqlExec) throws Exception {

    }
}
