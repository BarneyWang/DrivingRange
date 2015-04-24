package org.heng.threads.mode.Product;

/**
 * Created by wangdi5 on 2015/4/24.
 */
public class Productor  implements Runnable{


    Factory f = new Factory();

    public Productor(Factory f) {
        this.f = f;
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
    public synchronized void run() {
        for(int i = 0;i < 20;i++){
            Item item= new Item("aaa");
            f.product(item);
            try{
                Thread.sleep((int)(Math.random()*500));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
