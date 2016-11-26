package com.iqarr.fastdfs.proto.storage;

import java.io.InputStream;

import com.iqarr.fastdfs.dataobject.StorePath;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.internal.StorageUploadFileRequest;


/**
 * 
* @Title:文件上传命令
*	 	StorageUploadFileCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageUploadFileCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:45:37
* @version 
*		V1.0
 */
public class StorageUploadFileCommand extends AbstractFdfsCommand<StorePath> {

    /**
     * 文件上传命令
     * 
     * @param storeIndex 存储节点
     * @param inputStream 输入流
     * @param fileExtName 文件扩展名
     * @param size 文件大小
     * @param isAppenderFile 是否支持断点续传
     */
    public StorageUploadFileCommand(byte storeIndex, InputStream inputStream, String fileExtName, long fileSize,
            boolean isAppenderFile) {
        super();
        this.request = new StorageUploadFileRequest(storeIndex, inputStream, fileExtName, fileSize, isAppenderFile);
        // 输出响应
        this.response = new FdfsResponse<StorePath>() {
            // default response
        };
    }
    /**
     * 
    * <p>Title: 文件上传命令</p>  
    * <p>Description: 文件上传命令</p>  
    * @param storeIndex 存储节点
    * @param file  byte file
    * @param fileExtName  文件扩展名
    * @param fileSize 文件大小
    * @param isAppenderFile 是否支持断点续传
     */
    public StorageUploadFileCommand(byte storeIndex, byte [] file, String fileExtName, long fileSize,
                    boolean isAppenderFile) {
                super();
                this.request = new StorageUploadFileRequest(storeIndex, file, fileExtName, fileSize, isAppenderFile);
                // 输出响应
                this.response = new FdfsResponse<StorePath>() {
                    // default response
                };
            }

}
