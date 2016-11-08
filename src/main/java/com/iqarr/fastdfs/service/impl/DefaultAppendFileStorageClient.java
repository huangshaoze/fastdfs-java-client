package com.iqarr.fastdfs.service.impl;

import java.io.InputStream;

import com.iqarr.fastdfs.dataobject.StorageNode;
import com.iqarr.fastdfs.dataobject.StorageNodeInfo;
import com.iqarr.fastdfs.dataobject.StorePath;
import com.iqarr.fastdfs.pool.ConnectionManager;
import com.iqarr.fastdfs.proto.storage.StorageAppendFileCommand;
import com.iqarr.fastdfs.proto.storage.StorageModifyCommand;
import com.iqarr.fastdfs.proto.storage.StorageTruncateCommand;
import com.iqarr.fastdfs.proto.storage.StorageUploadFileCommand;
import com.iqarr.fastdfs.service.AppendFileStorageClient;
import com.iqarr.fastdfs.service.TrackerClient;


/**
 * 
* @Title:存储服务客户端接口实现
*	 	DefaultAppendFileStorageClient.java
* @Package 
*		com.iqarr.fastdfs.service.impl
* @ClassName: 
*		DefaultAppendFileStorageClient  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-14:35:02
* @version 
*		V1.0
 */
public class DefaultAppendFileStorageClient extends DefaultGenerateStorageClient implements AppendFileStorageClient {

    /**  
     * <p>Title: </p>  
     * <p>Description: </p>  
     * @param trackerClient
     * @param connectionManager  
     */
     public DefaultAppendFileStorageClient(TrackerClient trackerClient, ConnectionManager connectionManager) {
         super(trackerClient,connectionManager);
        
     }
    
    /**
     * 上传支持断点续传的文件
     */
    @Override
    public StorePath uploadAppenderFile(String groupName, InputStream inputStream, long fileSize, String fileExtName) {
        StorageNode client = trackerClient.getStoreStorage(groupName);
        StorageUploadFileCommand command = new StorageUploadFileCommand(client.getStoreIndex(), inputStream,
                fileExtName, fileSize, true);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 继续上载文件
     */
    @Override
    public void appendFile(String groupName, String path, InputStream inputStream, long fileSize) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, path);
        StorageAppendFileCommand command = new StorageAppendFileCommand(inputStream, fileSize, path);
        connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 修改文件
     */
    @Override
    public void modifyFile(String groupName, String path, InputStream inputStream, long fileSize, long fileOffset) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, path);
        StorageModifyCommand command = new StorageModifyCommand(path, inputStream, fileSize, fileOffset);
        connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);

    }

    /**
     * 清除文件
     */
    @Override
    public void truncateFile(String groupName, String path, long truncatedFileSize) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, path);
        StorageTruncateCommand command = new StorageTruncateCommand(path, truncatedFileSize);
        connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 清除文件
     */
    @Override
    public void truncateFile(String groupName, String path) {
        long truncatedFileSize = 0;
        truncateFile(groupName, path, truncatedFileSize);
    }

}
