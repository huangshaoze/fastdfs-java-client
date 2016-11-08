package com.iqarr.fastdfs.proto.storage;

import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.storage.internal.StorageDownloadRequest;
import com.iqarr.fastdfs.proto.storage.internal.StorageDownloadResponse;


/**
 * 
* @Title:文件下载命令
*	 	StorageDownloadCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageDownloadCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:43:51
* @version 
*		V1.0    
* @param <T>
 */
public class StorageDownloadCommand<T> extends AbstractFdfsCommand<T> {

    /**
     * 下载文件
     * 
     * @param groupName
     * @param path
     * @param fileOffset
     * @param fileSize
     */
    public StorageDownloadCommand(String groupName, String path, long fileOffset, long fileSize,
            DownloadCallback<T> callback) {
        super();
        this.request = new StorageDownloadRequest(groupName, path, fileOffset, fileSize);
        // 输出响应
        this.response = new StorageDownloadResponse<T>(callback);
    }

    /**
     * 下载文件
     * 
     * @param groupName
     * @param path
     */
    public StorageDownloadCommand(String groupName, String path, DownloadCallback<T> callback) {
        super();
        this.request = new StorageDownloadRequest(groupName, path, 0, 0);
        // 输出响应
        this.response = new StorageDownloadResponse<T>(callback);
    }
}
