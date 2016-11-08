package com.iqarr.fastdfs.service;

import java.util.List;

import com.iqarr.fastdfs.dataobject.GroupState;
import com.iqarr.fastdfs.dataobject.StorageNode;
import com.iqarr.fastdfs.dataobject.StorageNodeInfo;
import com.iqarr.fastdfs.dataobject.StorageState;


/**
 * 目录服务(Tracker)客户端接口
* @Title:
*	 	TrackerClient.java
* @Package 
*		com.iqarr.fastdfs.service
* @ClassName: 
*		TrackerClient  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-10:00:56
* @version 
*		V1.0
 */
public interface TrackerClient {

    /**
     * 获取存储节点 get the StoreStorage Client
     * 
     * @return
     */
    StorageNode getStoreStorage();

    /**
     * 按组获取存储节点 get the StoreStorage Client by group
     * 
     * @param groupName
     * @return
     */
    StorageNode getStoreStorage(String groupName);

    /**
     * 获取读取存储节点 get the fetchStorage Client by group and filename
     * 
     * @param groupName
     * @param filename
     * @return
     */
    StorageNodeInfo getFetchStorage(String groupName, String filename);

    /**
     * 获取更新节点 get the updateStorage Client by group and filename
     * 
     * @param groupName
     * @param filename
     * @return
     */
    StorageNodeInfo getUpdateStorage(String groupName, String filename);

    /**
     * 获取组状态list groups
     * 
     * @return
     */
    List<GroupState> listGroups();

    /**
     * 按组名获取存储节点状态list storages by groupName
     * 
     * @param groupName
     * @return
     */
    List<StorageState> listStorages(String groupName);

    /**
     * 获取存储状态 list storages by groupName and storageIpAddr
     * 
     * @param groupName
     * @param storageIpAddr
     * @return
     */
    List<StorageState> listStorages(String groupName, String storageIpAddr);

    /**
     * 删除存储节点 delete storage from TrackerServer
     * 
     * @param groupName
     * @param storageIpAddr
     */
    void deleteStorage(String groupName, String storageIpAddr);

}
