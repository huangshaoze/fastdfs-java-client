package com.iqarr.fastdfs.proto.tracker.internal;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:列出分组命令
*	 	TrackerListGroupsRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker.internal
* @ClassName: 
*		TrackerListGroupsRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:53:19
* @version 
*		V1.0
 */
public class TrackerListGroupsRequest extends FdfsRequest {

    public TrackerListGroupsRequest() {
        head = new ProtoHead(CmdConstants.TRACKER_PROTO_CMD_SERVER_LIST_GROUP);
    }
}
