package org.heng.threads.mutil;

import java.util.concurrent.*;

/**
 * Created by wangdi5 on 2015/4/24.
 */
public abstract class AsychronExecutors {


     private final static ExecutorService executors = Executors.newCachedThreadPool();

    private final static LinkedBlockingQueue<Future> futureQueue = new LinkedBlockingQueue<Future>(100);
    public final static LinkedBlockingQueue<Callable> callQueue = new LinkedBlockingQueue<Callable>(100);

    public void run(){

        while(true){
            if(!callQueue.isEmpty()){

           Callable c= callQueue.poll();
            executors.submit(c);
            }else{
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }

    }



    public  Future getResult(){

        return futureQueue.poll();
    }


}
