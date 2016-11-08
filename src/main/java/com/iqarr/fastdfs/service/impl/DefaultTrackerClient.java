package com.iqarr.fastdfs.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.iqarr.fastdfs.dataobject.GroupState;
import com.iqarr.fastdfs.dataobject.StorageNode;
import com.iqarr.fastdfs.dataobject.StorageNodeInfo;
import com.iqarr.fastdfs.dataobject.StorageState;
import com.iqarr.fastdfs.pool.TrackerConnectionManager;
import com.iqarr.fastdfs.proto.tracker.TrackerDeleteStorageCommand;
import com.iqarr.fastdfs.proto.tracker.TrackerGetFetchStorageCommand;
import com.iqarr.fastdfs.proto.tracker.TrackerGetStoreStorageCommand;
import com.iqarr.fastdfs.proto.tracker.TrackerListGroupsCommand;
import com.iqarr.fastdfs.proto.tracker.TrackerListStoragesCommand;
import com.iqarr.fastdfs.service.TrackerClient;



/**
 * 
* @Title:目录服务客户端默认实现
*	 	DefaultTrackerClient.java
* @Package 
*		com.iqarr.fastdfs.service.impl
* @ClassName: 
*		DefaultTrackerClient  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/11/08-08:50:47
* @version 
*		V1.0
 */
public class DefaultTrackerClient implements TrackerClient {

   
    private TrackerConnectionManager trackerConnectionManager;

    
    
    
    /**  
    * <p>Title: </p>  
    * <p>Description: </p>    
    */
    public DefaultTrackerClient() {
        super();
        this.trackerConnectionManager =new TrackerConnectionManager();
    }

    /**  
    * <p>Title: </p>  
    * <p>Description: </p>  
    * @param trackerConnectionManager  
    */
    public DefaultTrackerClient(TrackerConnectionManager trackerConnectionManager) {
        super();
        this.trackerConnectionManager = trackerConnectionManager;
    }

    /**
     * 获取存储节点
     */
    @Override
    public StorageNode getStoreStorage() {
        TrackerGetStoreStorageCommand command = new TrackerGetStoreStorageCommand();
        return trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

    /**
     * 按组获取存储节点
     */
    @Override
    public StorageNode getStoreStorage(String groupName) {
        TrackerGetStoreStorageCommand command;
        if (StringUtils.isBlank(groupName)) {
            command = new TrackerGetStoreStorageCommand();
        } else {
            command = new TrackerGetStoreStorageCommand(groupName);
        }

        return trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

    /**
     * 获取源服务器
     */
    @Override
    public StorageNodeInfo getFetchStorage(String groupName, String filename) {
        TrackerGetFetchStorageCommand command = new TrackerGetFetchStorageCommand(groupName, filename, false);
        return trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

    /**
     * 获取更新服务器
     */
    @Override
    public StorageNodeInfo getUpdateStorage(String groupName, String filename) {
        TrackerGetFetchStorageCommand command = new TrackerGetFetchStorageCommand(groupName, filename, true);
        return trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

    /**
     * 列出组
     */
    @Override
    public List<GroupState> listGroups() {
        TrackerListGroupsCommand command = new TrackerListGroupsCommand();
        return trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

    /**
     * 按组列出存储状态
     */
    @Override
    public List<StorageState> listStorages(String groupName) {
        TrackerListStoragesCommand command = new TrackerListStoragesCommand(groupName);
        return trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

    /**
     * 按ip列出存储状态
     */
    @Override
    public List<StorageState> listStorages(String groupName, String storageIpAddr) {
        TrackerListStoragesCommand command = new TrackerListStoragesCommand(groupName, storageIpAddr);
        return trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

    /**
     * 删除存储节点
     */
    @Override
    public void deleteStorage(String groupName, String storageIpAddr) {
        TrackerDeleteStorageCommand command = new TrackerDeleteStorageCommand(groupName, storageIpAddr);
        trackerConnectionManager.executeFdfsTrackerCmd(command);
    }

}
