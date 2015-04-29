package org.heng.threads.mutil;

import java.util.concurrent.Callable;

/**
 * Created by wangdi5 on 2015/4/24.
 */
public class SubmitCallable  extends  AsychronExecutors{


    private  Callable c;

//    public SubmitCallable(Callable<Integer> c){
//        this.c = c;
//    }






    public static void main(String[] args)  {

        SubmitCallable call = new SubmitCallable();

        Callable  c = new Callable() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override
            public Object call() throws Exception {

                return 1;
            }
        };

        try {
            callQueue.put(c);
          call.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
