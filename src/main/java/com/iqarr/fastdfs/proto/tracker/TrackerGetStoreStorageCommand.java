package com.iqarr.fastdfs.proto.tracker;

import com.iqarr.fastdfs.dataobject.StorageNode;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerGetStoreStorageRequest;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerGetStoreStorageWithGroupRequest;


/**
 * 
* @Title:获取存储节点命令
*	 	TrackerGetStoreStorageCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker
* @ClassName: 
*		TrackerGetStoreStorageCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:56:23
* @version 
*		V1.0
 */
public class TrackerGetStoreStorageCommand extends AbstractFdfsCommand<StorageNode> {

    public TrackerGetStoreStorageCommand(String groupName) {
        super.request = new TrackerGetStoreStorageWithGroupRequest(groupName);
        super.response = new FdfsResponse<StorageNode>() {
            // default response
        };
    }

    public TrackerGetStoreStorageCommand() {
        super.request = new TrackerGetStoreStorageRequest();
        super.response = new FdfsResponse<StorageNode>() {
            // default response
        };
    }

}
