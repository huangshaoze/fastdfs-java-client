package com.iqarr.fastdfs.proto.tracker.internal;

import org.apache.commons.lang3.Validate;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.DynamicFieldType;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:列出存储状态
*	 	TrackerListStoragesRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker.internal
* @ClassName: 
*		TrackerListStoragesRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:53:47
* @version 
*		V1.0
 */
public class TrackerListStoragesRequest extends FdfsRequest {

    /** 组名 */
    @FastdfsColumn(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;
    /** 存储服务器ip地址 */
    @FastdfsColumn(index = 1, max = OtherConstants.FDFS_IPADDR_SIZE - 1, dynamicField = DynamicFieldType.nullable)
    private String storageIpAddr;

    public TrackerListStoragesRequest() {
        head = new ProtoHead(CmdConstants.TRACKER_PROTO_CMD_SERVER_LIST_STORAGE);
    }

    /**
     * 列举存储服务器状态
     * 
     * @param groupName
     * @param storageIpAddr
     */
    public TrackerListStoragesRequest(String groupName, String storageIpAddr) {
        this();
        Validate.notBlank(groupName, "分组不能为空");
        this.groupName = groupName;
        this.storageIpAddr = storageIpAddr;
    }

    /**
     * 列举组当中存储节点状态
     * 
     * @param groupName
     */
    public TrackerListStoragesRequest(String groupName) {
        this();
        this.groupName = groupName;
        Validate.notBlank(groupName, "分组不能为空");
    }

    public String getGroupName() {
        return groupName;
    }

    public String getStorageIpAddr() {
        return storageIpAddr;
    }

}
