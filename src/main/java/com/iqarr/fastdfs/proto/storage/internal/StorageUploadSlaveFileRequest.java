package com.iqarr.fastdfs.proto.storage.internal;

import java.io.InputStream;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.DynamicFieldType;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:从文件上传命令
*	 	StorageUploadSlaveFileRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageUploadSlaveFileRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:41:30
* @version 
*		V1.0
 */
public class StorageUploadSlaveFileRequest extends FdfsRequest {

    /** 主文件名长度 */
    @FastdfsColumn(index = 0)
    private long masterFileNameSize;
    /** 发送文件长度 */
    @FastdfsColumn(index = 1)
    private long fileSize;
    /** 名称前缀 */
    @FastdfsColumn(index = 2, max = OtherConstants.FDFS_FILE_PREFIX_MAX_LEN)
    private final String prefixName;
    /** 文件扩展名 */
    @FastdfsColumn(index = 3, max = OtherConstants.FDFS_FILE_EXT_NAME_MAX_LEN)
    private String fileExtName;
    /** 主文件名 */
    @FastdfsColumn(index = 4, dynamicField = DynamicFieldType.allRestByte)
    private final String masterFilename;

    /**
     * 构造函数
     * 
     * @param storeIndex
     * @param inputStream
     * @param masterFilename
     * @param fileExtName
     * @param prefixName
     * @param fileSize
     * @param isAppenderFile
     */
    public StorageUploadSlaveFileRequest(InputStream inputStream, long fileSize, String masterFilename,
            String prefixName, String fileExtName) {
        super();
        this.inputFile = inputStream;
        this.fileSize = fileSize;
        this.masterFileNameSize = masterFilename.length();
        this.masterFilename = masterFilename;
        this.fileExtName = fileExtName;
        this.prefixName = prefixName;
        head = new ProtoHead(CmdConstants.STORAGE_PROTO_CMD_UPLOAD_SLAVE_FILE);

    }

    public long getMasterFileNameSize() {
        return masterFileNameSize;
    }

    public void setMasterFileNameSize(long masterFileNameSize) {
        this.masterFileNameSize = masterFileNameSize;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public String getMasterFilename() {
        return masterFilename;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtName() {
        return fileExtName;
    }

    public void setFileExtName(String fileExtName) {
        this.fileExtName = fileExtName;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

}
