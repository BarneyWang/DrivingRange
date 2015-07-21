package org.heng.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by wangdi5 on 2015/6/9.
 */
public class ZkNodeOperation {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //String zkServer = "192.168.58.13:2181";

        ZooKeeper zk = new ZooKeeper("10.154.250.38:" + 3181, 3000,
                new Watcher() {
                    // 监控所有被触发的事件
                    public void process(WatchedEvent event) {
                        System.out.println("已经触发了" + event.getType() + "事件！");
                    }
                });
        // 创建一个目录节点
        zk.create("/wangdi-dir", "wangdi-data".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // 创建一个子目录节点
        zk.create("/wangdi-dir/childone", "childone".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk
                .getData("/wangdi-dir", false, null)));
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/wangdi-dir", true));
        // 修改子目录节点数据
        zk.setData("/wangdi-dir/childone", "modifyDataOne".getBytes(), -1);
        System.out.println("目录节点状态：[" + zk.exists("/wangdi-dir", true)
                + "]");
        // 创建另外一个子目录节点
        zk.create("/wangdi-dir/childtwo", "childtwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/wangdi-dir/childtwo",
                true, null)));
        // 删除子目录节点
        zk.delete("/wangdi-dir/childtwo", -1);
        zk.delete("/wangdi-dir/childone", -1);
        // 删除父目录节点
        zk.delete("/wangdi-dir", -1);
        // 关闭zk连接
        zk.close();
    }
}
