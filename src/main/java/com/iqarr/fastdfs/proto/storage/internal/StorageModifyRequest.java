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
* @Title:文件修改请求
*	 	StorageModifyRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageModifyRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:33:21
* @version 
*		V1.0
 */
public class StorageModifyRequest extends FdfsRequest {

    /** 文件路径长度 */
    @FastdfsColumn(index = 0)
    private long pathSize;
    /** 开始位置 */
    @FastdfsColumn(index = 1)
    private long fileOffset;
    /** 发送文件长度 */
    @FastdfsColumn(index = 2)
    private long fileSize;
    /** 文件路径 */
    @FastdfsColumn(index = 3, dynamicField = DynamicFieldType.allRestByte)
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
    public StorageModifyRequest(InputStream inputStream, long fileSize, String path, long fileOffset) {
        super();
        this.inputFile = inputStream;
        this.fileSize = fileSize;
        this.path = path;
        this.fileOffset = fileOffset;
        head = new ProtoHead(CmdConstants.STORAGE_PROTO_CMD_MODIFY_FILE);

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

    public long getFileOffset() {
        return fileOffset;
    }

    public String getPath() {
        return path;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

}
