package org.heng.threads.mode.Product;

/**
 * Created by wangdi5 on 2015/4/24.
 */
public class Item {



    public  Item(String name){
        this.name= name;

    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
