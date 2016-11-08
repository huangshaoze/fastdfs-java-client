package com.iqarr.fastdfs.proto.tracker;

import java.util.List;

import com.iqarr.fastdfs.dataobject.GroupState;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerListGroupsRequest;
import com.iqarr.fastdfs.proto.tracker.internal.TrackerListGroupsResponse;


/**
 * 
* @Title:列出组命令
*	 	TrackerListGroupsCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker
* @ClassName: 
*		TrackerListGroupsCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:56:36
* @version 
*		V1.0
 */
public class TrackerListGroupsCommand extends AbstractFdfsCommand<List<GroupState>> {

    public TrackerListGroupsCommand() {
        super.request = new TrackerListGroupsRequest();
        super.response = new TrackerListGroupsResponse();
    }

}
