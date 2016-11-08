package com.iqarr.fastdfs.proto.storage.internal;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.DynamicFieldType;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;

/**
 * 
* @Title:文件下载请求
*	 	StorageDownloadRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageDownloadRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/11/08-08:50:26
* @version 
*		V1.0
 */
public class StorageDownloadRequest extends FdfsRequest {

    /** 开始位置 */
    @FastdfsColumn(index = 0)
    private long fileOffset;
    /** 读取文件长度 */
    @FastdfsColumn(index = 1)
    private long fileSize;
    /** 组名 */
    @FastdfsColumn(index = 2, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;
    /** 文件路径 */
    @FastdfsColumn(index = 3, dynamicField = DynamicFieldType.allRestByte)
    private String path;

    /**
     * 文件下载请求
     * 
     * @param groupName
     * @param path
     * @param fileOffset
     * @param fileSize
     */
    public StorageDownloadRequest(String groupName, String path, long fileOffset, long fileSize) {
        super();
        this.groupName = groupName;
        this.fileSize = fileSize;
        this.path = path;
        this.fileOffset = fileOffset;
        head = new ProtoHead(CmdConstants.STORAGE_PROTO_CMD_DOWNLOAD_FILE);

    }

    public long getFileOffset() {
        return fileOffset;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getPath() {
        return path;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

}
