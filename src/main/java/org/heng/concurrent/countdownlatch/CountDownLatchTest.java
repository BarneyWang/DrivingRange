package org.heng.concurrent.countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 *
 * CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 * Created by wangdi5 on 2015/4/28.
 */
public class CountDownLatchTest {

    final static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(2);//两个工人的协作
        Worker worker1=new Worker("zhang san", 5000, latch);
        Worker worker2=new Worker("li si", 8000, latch);
        new Thread(worker1).start();//
        new Thread(worker2).start();//
        //等待所有工人完成工作
        latch.await();
        System.out.println("all work done at " + sdf.format(new Date()));

    }
}
