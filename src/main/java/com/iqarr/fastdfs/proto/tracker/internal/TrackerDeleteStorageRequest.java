package com.iqarr.fastdfs.proto.tracker.internal;

import org.apache.commons.lang3.Validate;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:移除存储服务器
*	 	TrackerDeleteStorageRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker.internal
* @ClassName: 
*		TrackerDeleteStorageRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:49:54
* @version 
*		V1.0
 */
public class TrackerDeleteStorageRequest extends FdfsRequest {

    /** 组名 */
    @FastdfsColumn(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;
    /** 存储ip */
    @FastdfsColumn(index = 1, max = OtherConstants.FDFS_IPADDR_SIZE - 1)
    private String storageIpAddr;

    /**
     * 获取文件源服务器
     * 
     * @param groupName
     * @param path
     */
    public TrackerDeleteStorageRequest(String groupName, String storageIpAddr) {
        Validate.notBlank(groupName, "分组不能为空");
        Validate.notBlank(storageIpAddr, "文件路径不能为空");
        this.groupName = groupName;
        this.storageIpAddr = storageIpAddr;
        head = new ProtoHead(CmdConstants.TRACKER_PROTO_CMD_SERVER_DELETE_STORAGE);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getStorageIpAddr() {
        return storageIpAddr;
    }

}
