package com.iqarr.fastdfs.proto.tracker.internal;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:获取存储节点请求
*	 	TrackerGetStoreStorageRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker.internal
* @ClassName: 
*		TrackerGetStoreStorageRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:52:54
* @version 
*		V1.0
 */
public class TrackerGetStoreStorageRequest extends FdfsRequest {

    private static final byte withoutGroupCmd = CmdConstants.TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITHOUT_GROUP_ONE;

    /**
     * 获取存储节点
     * 
     * @param groupName
     */
    public TrackerGetStoreStorageRequest() {
        super();
        this.head = new ProtoHead(withoutGroupCmd);
    }

}
