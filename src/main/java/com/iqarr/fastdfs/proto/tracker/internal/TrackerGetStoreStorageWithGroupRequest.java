package com.iqarr.fastdfs.proto.tracker.internal;

import org.apache.commons.lang3.Validate;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:按分组获取存储节点
*	 	TrackerGetStoreStorageWithGroupRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker.internal
* @ClassName: 
*		TrackerGetStoreStorageWithGroupRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:53:05
* @version 
*		V1.0
 */
public class TrackerGetStoreStorageWithGroupRequest extends FdfsRequest {

    private static final byte withGroupCmd = CmdConstants.TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITH_GROUP_ONE;

    /**
     * 分组定义
     */
    @FastdfsColumn(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private final String groupName;

    /**
     * 获取存储节点
     * 
     * @param groupName
     */
    public TrackerGetStoreStorageWithGroupRequest(String groupName) {
        Validate.notBlank(groupName, "分组不能为空");
        this.groupName = groupName;
        this.head = new ProtoHead(withGroupCmd);
    }

    public String getGroupName() {
        return groupName;
    }

}
