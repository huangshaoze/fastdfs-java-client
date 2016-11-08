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
* @Title:获取源服务器
*	 	TrackerGetFetchStorageRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.tracker.internal
* @ClassName: 
*		TrackerGetFetchStorageRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:52:24
* @version 
*		V1.0
 */
public class TrackerGetFetchStorageRequest extends FdfsRequest {

    private static final byte fetchCmd = CmdConstants.TRACKER_PROTO_CMD_SERVICE_QUERY_FETCH_ONE;
    private static final byte updateCmd = CmdConstants.TRACKER_PROTO_CMD_SERVICE_QUERY_UPDATE;

    /** 组名 */
    @FastdfsColumn(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;
    /** 路径名 */
    @FastdfsColumn(index = 1, dynamicField = DynamicFieldType.allRestByte)
    private String path;

    /**
     * 获取文件源服务器
     * 
     * @param groupName
     * @param path
     */
    public TrackerGetFetchStorageRequest(String groupName, String path, boolean toUpdate) {
        Validate.notBlank(groupName, "分组不能为空");
        Validate.notBlank(path, "文件路径不能为空");
        this.groupName = groupName;
        this.path = path;
        if (toUpdate) {
            head = new ProtoHead(updateCmd);
        } else {
            head = new ProtoHead(fetchCmd);
        }
    }

    public String getGroupName() {
        return groupName;
    }

    public String getPath() {
        return path;
    }

}
