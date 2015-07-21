package org.heng.zookeeper;

import org.apache.helix.manager.zk.ZkClient;

import java.net.InetAddress;

/**
 * Created by wangdi5 on 2015/6/9.
 */
public class ServiceAProvider {

    private String serviceName = "service";

    //向zookeeper注册服务
    public void init() throws Exception{
        String serverList = "10.154.250.38:3181";
        String PATH ="/configcenter";//根节点路径
        ZkClient zkClient = new ZkClient(serverList);
        boolean rootExists = zkClient.exists(PATH);
        if(!rootExists){
            zkClient.createPersistent(PATH);
        }
        //判断是否存在，不存在则创建服务节点
        boolean serviceExists = zkClient.exists(PATH + "/" + serviceName);
        if(!serviceExists){
            zkClient.createPersistent(PATH + "/" + serviceName);
        }

        //注册当前服务
        InetAddress addr =InetAddress.getLocalHost();
        //String ip= addr.getHostAddress().toString();
        String ip = "10.154.250.38";

        //创建当前节点服务器
        zkClient.createEphemeral(PATH + "/" + serviceName + "/" + ip);

        System.out.println("提供的服务节点名称为："+PATH + "/" + serviceName + "/" + ip);
    }
    //提供服务
    public void provide(){

    }
    public static void main(String[]args) throws Exception {
        ServiceAProvider service = new ServiceAProvider();
        service.init();

        Thread.sleep(1000*60*60*24);
    }
}
