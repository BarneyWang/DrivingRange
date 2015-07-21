package org.heng.zookeeper.banlance.impl;

import org.apache.helix.manager.zk.ZkClient;
import org.heng.zookeeper.Constant;
import org.heng.zookeeper.banlance.LoadBlance;

import java.util.List;

/**
 * 轮询
 * Created by wangdi5 on 2015/7/6.
 */
public class RoundRobinLoadBalance implements LoadBlance {

    @Override
    public String select(String zkServer) {
        ZkClient zkClient = new ZkClient(zkServer);
        List<String> serverList = zkClient.getChildren(Constant.root);
        int round=0;
        if(!zkClient.exists(Constant.round)){
            zkClient.createPersistent(Constant.round);
            zkClient.writeData(Constant.round, 0);
        }else{
            round=(Integer)zkClient.readData(Constant.round);
            zkClient.writeData(Constant.round, ++round);
        }
        zkClient.close();
        if (serverList != null && serverList.size() > 0) {
            return serverList.get(round % serverList.size());
        } else {
            return null;
        }

    }
}
