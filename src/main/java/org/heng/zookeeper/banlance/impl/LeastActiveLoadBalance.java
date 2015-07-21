package org.heng.zookeeper.banlance.impl;

import org.apache.helix.manager.zk.ZkClient;
import org.heng.zookeeper.Constant;
import org.heng.zookeeper.banlance.LoadBlance;

import java.util.List;

/**
 * Lru
 * Created by wangdi5 on 2015/7/6.
 */
public class LeastActiveLoadBalance implements LoadBlance {

    @Override
    public String select(String zkServer) {
        ZkClient zkClient = new ZkClient(zkServer);
        List<String> serverList = zkClient.getChildren(Constant.root);

        String tempServer = null;
        int tempConn = -1;
        for (int i = 0; i < serverList.size(); i++) {
            String server = serverList.get(i);
            if (zkClient.readData(Constant.root + "/" + server) != null) {
                int connNum = zkClient.readData(Constant.root + "/" + server);
                if (tempConn == -1) {
                    tempServer = server;
                    tempConn = connNum;
                }
                if (connNum < tempConn) {
                    tempServer = server;
                    tempConn = connNum;
                }
            }else{
                zkClient.close();
                return server;
            }
        }
        zkClient.close();
        if (tempServer != null && !tempServer.equals("")) {
            return tempServer;
        }

        return null;
    }
}
