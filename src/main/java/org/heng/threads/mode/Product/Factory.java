package org.heng.threads.mode.Product;

/**
 * Created by wangdi5 on 2015/4/24.
 */
public class Factory {

   public  static  Item[] warehouse = new Item[6];
    private int index;


    /**
     * 生产
     */
   public synchronized void product(Item item){
       try {
           if(index == warehouse.length){
               System.out.println("生产满了");
               this.wait();
           }
           this.notify();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       warehouse[index]=item;
       index++;
       System.out.println("生产了：" + item.toString() + " 共" + index + "个馒头");

   }

    /**
     * 消费
     */
    public synchronized  Item pop(){

        try {
            if(index==0){
                System.out.println("消费光了");
                this.wait();
            }
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        index--;
        System.out.println("消费了：---------" + warehouse[index].toString() + " 共" + index + "个馒头");
        return warehouse[index];
    }



}
