package org.heng.jvm.clazz;

/**
 * VM OPTIONS: -XX:+TraceClassLoading
 * Created by wangdi5 on 2016/5/11.
 */
public class NotInitialization {
//    public static void main(String[] args) {
//        System.out.println(Subclass.value);
//    }


//    public static void main(String[] args) {
//        Superclass[] sca = new Superclass[5];
//    }


    static{

        int i =0;
        System.out.println(i);
    }

    static int i = 1 ;


    public static void main(String[] args) {
        System.out.println(i);
    }
}
