package org.heng.concurrent.countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangdi5 on 2015/4/28.
 */
public class Worker implements Runnable {

    final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String workerName;
    int workTime;
    CountDownLatch latch;

    public Worker(String workerName ,int workTime ,CountDownLatch latch){
        this.workerName=workerName;
        this.workTime=workTime;
        this.latch=latch;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run(){
        System.out.println("Worker "+workerName+" do work begin at "+sdf.format(new Date()));
        doWork();//工作了
        System.out.println("Worker "+workerName+" do work complete at "+sdf.format(new Date()));
        //run方法执行后 执行latch的countDown方法
        latch.countDown();//工人完成工作，计数器减一

    }

    private void doWork(){
        try {
            Thread.sleep(workTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
