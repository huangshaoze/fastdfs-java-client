package com.iqarr.fastdfs.proto.storage.internal;

import java.io.InputStream;
import java.nio.charset.Charset;


import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.mapperfactory.DynamicFieldType;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:文件上传命令
*	 	StorageAppendFileRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageAppendFileRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/11/08-08:49:59
* @version 
*		V1.0
 */
public class StorageAppendFileRequest extends FdfsRequest {

    /** 文件路径长度 */
    @FastdfsColumn(index = 0)
    private long pathSize;
    /** 发送文件长度 */
    @FastdfsColumn(index = 1)
    private long fileSize;
    /** 文件路径 */
    @FastdfsColumn(index = 2, dynamicField = DynamicFieldType.allRestByte)
    private String path;

    /**
     * 构造函数
     * 
     * @param inputStream
     * @param fileExtName
     * @param fileSize
     * @param storeIndex
     * @param isAppenderFile
     */
    public StorageAppendFileRequest(InputStream inputStream, long fileSize, String path) {
        super();
        this.inputFile = inputStream;
        this.fileSize = fileSize;
        this.path = path;
        head = new ProtoHead(CmdConstants.STORAGE_PROTO_CMD_APPEND_FILE);
    }

    /**
     * 打包参数
     */
    @Override
    public byte[] encodeParam(Charset charset) {
        // 运行时参数在此计算值
        this.pathSize = path.getBytes(charset).length;
        return super.encodeParam(charset);
    }

    public long getPathSize() {
        return pathSize;
    }

    public void setPathSize(long pathSize) {
        this.pathSize = pathSize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return "StorageAppendFileRequest [pathSize=" + pathSize + ", fileSize=" + fileSize + ", path=" + path + "]";
    }

}
