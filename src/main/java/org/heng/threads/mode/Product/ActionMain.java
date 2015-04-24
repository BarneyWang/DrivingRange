package org.heng.threads.mode.Product;


/**
 * Created by wangdi5 on 2015/4/24.
 */
public class ActionMain {


    public static void main(String[] args) {

        Factory s = new Factory();
        Productor p = new Productor(s);
        Customer c = new Customer(s);

        for(int i =0;i<100;i++){
            Thread tp = new Thread(p);
            tp.start();
        }
        for(int i =0;i<20;i++){

        Thread tc = new Thread(c);
        tc.start();
        }
    }
}
