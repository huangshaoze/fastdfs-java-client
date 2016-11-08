package com.iqarr.fastdfs.proto.storage.internal;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.DynamicFieldType;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:查询文件信息命令
*	 	StorageQueryFileInfoRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageQueryFileInfoRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:34:30
* @version 
*		V1.0
 */
public class StorageQueryFileInfoRequest extends FdfsRequest {

    /** 组名 */
    @FastdfsColumn(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;
    /** 路径名 */
    @FastdfsColumn(index = 1, dynamicField = DynamicFieldType.allRestByte)
    private String path;

    /**
     * 删除文件命令
     * 
     * @param groupName
     * @param path
     */
    public StorageQueryFileInfoRequest(String groupName, String path) {
        super();
        this.groupName = groupName;
        this.path = path;
        this.head = new ProtoHead(CmdConstants.STORAGE_PROTO_CMD_QUERY_FILE_INFO);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
