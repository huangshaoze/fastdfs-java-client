package com.iqarr.fastdfs.proto.tracker;

import com.iqarr.fastdfs.dataobject.StorageNodeInfo;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerGetFetchStorageRequest;


/**
 * 
* @Title:获取源服务器
*	 	TrackerGetFetchStorageCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker
* @ClassName: 
*		TrackerGetFetchStorageCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:56:11
* @version 
*		V1.0
 */
public class TrackerGetFetchStorageCommand extends AbstractFdfsCommand<StorageNodeInfo> {

    public TrackerGetFetchStorageCommand(String groupName, String path, boolean toUpdate) {
        super.request = new TrackerGetFetchStorageRequest(groupName, path, toUpdate);
        super.response = new FdfsResponse<StorageNodeInfo>() {
            // default response
        };
    }

}
