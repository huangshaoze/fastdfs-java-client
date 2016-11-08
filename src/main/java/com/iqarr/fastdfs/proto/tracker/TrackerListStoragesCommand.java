package com.iqarr.fastdfs.proto.tracker;

import java.util.List;

import com.iqarr.fastdfs.dataobject.StorageState;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerListStoragesRequest;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerListStoragesResponse;


/**
 * 
* @Title:列出组命令
*	 	TrackerListStoragesCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker
* @ClassName: 
*		TrackerListStoragesCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:56:47
* @version 
*		V1.0
 */
public class TrackerListStoragesCommand extends AbstractFdfsCommand<List<StorageState>> {

    public TrackerListStoragesCommand(String groupName, String storageIpAddr) {
        super.request = new TrackerListStoragesRequest(groupName, storageIpAddr);
        super.response = new TrackerListStoragesResponse();
    }

    public TrackerListStoragesCommand(String groupName) {
        super.request = new TrackerListStoragesRequest(groupName);
        super.response = new TrackerListStoragesResponse();
    }

}
