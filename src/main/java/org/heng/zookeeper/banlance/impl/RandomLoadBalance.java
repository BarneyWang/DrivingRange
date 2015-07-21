package org.heng.zookeeper.banlance.impl;

import org.apache.helix.manager.zk.ZkClient;
import org.heng.zookeeper.Constant;
import org.heng.zookeeper.banlance.LoadBlance;

import java.util.List;
import java.util.Random;

/**
 * 随机负载
 * Created by wangdi5 on 2015/7/6.
 */
public class RandomLoadBalance implements LoadBlance {
    @Override
    public String select(String zkServer) {

        ZkClient zkClient = new ZkClient(zkServer);
        List<String> serverList = zkClient.getChildren(Constant.root);
        zkClient.close();
        Random r=new Random();
        if(serverList.size()>=1){
            String server=serverList.get(r.nextInt(serverList.size()));
            return server;
        }else{
            return null;
        }
    }
}
