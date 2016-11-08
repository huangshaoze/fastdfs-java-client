package com.iqarr.fastdfs.proto.storage.internal;

import java.io.InputStream;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:文件上传命令
*	 	StorageUploadFileRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageUploadFileRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:40:56
* @version 
*		V1.0
 */
public class StorageUploadFileRequest extends FdfsRequest {

    private static final byte uploadCmd = CmdConstants.STORAGE_PROTO_CMD_UPLOAD_FILE;
    private static final byte uploadAppenderCmd = CmdConstants.STORAGE_PROTO_CMD_UPLOAD_APPENDER_FILE;

    /** 存储节点index */
    @FastdfsColumn(index = 0)
    private byte storeIndex;
    /** 发送文件长度 */
    @FastdfsColumn(index = 1)
    private long fileSize;
    /** 文件扩展名 */
    @FastdfsColumn(index = 2, max = OtherConstants.FDFS_FILE_EXT_NAME_MAX_LEN)
    private String fileExtName;

    /**
     * 构造函数
     * 
     * @param inputStream
     * @param fileExtName
     * @param fileSize
     * @param storeIndex
     * @param isAppenderFile
     */
    public StorageUploadFileRequest(byte storeIndex, InputStream inputStream, String fileExtName, long fileSize,
            boolean isAppenderFile) {
        super();
        this.inputFile = inputStream;
        this.fileSize = fileSize;
        this.storeIndex = storeIndex;
        this.fileExtName = fileExtName;
        if (isAppenderFile) {
            head = new ProtoHead(uploadAppenderCmd);
        } else {
            head = new ProtoHead(uploadCmd);
        }
    }

    public byte getStoreIndex() {
        return storeIndex;
    }

    public void setStoreIndex(byte storeIndex) {
        this.storeIndex = storeIndex;
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
