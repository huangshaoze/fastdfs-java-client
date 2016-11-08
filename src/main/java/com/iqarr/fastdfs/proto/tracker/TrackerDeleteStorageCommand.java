package com.iqarr.fastdfs.proto.tracker;

import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerDeleteStorageRequest;


/**
 * 
* @Title:移除存储服务器命令
*	 	TrackerDeleteStorageCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker
* @ClassName: 
*		TrackerDeleteStorageCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:48:37
* @version 
*		V1.0
 */
public class TrackerDeleteStorageCommand extends AbstractFdfsCommand<Void> {

    public TrackerDeleteStorageCommand(String groupName, String storageIpAddr) {
        super.request = new TrackerDeleteStorageRequest(groupName, storageIpAddr);
        super.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
