package com.iqarr.fastdfs.service.impl;

import java.io.InputStream;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iqarr.fastdfs.dataobject.FileInfo;
import com.iqarr.fastdfs.dataobject.MateData;
import com.iqarr.fastdfs.dataobject.StorageNode;
import com.iqarr.fastdfs.dataobject.StorageNodeInfo;
import com.iqarr.fastdfs.dataobject.StorePath;
import com.iqarr.fastdfs.pool.ConnectionManager;
import com.iqarr.fastdfs.proto.storage.DownloadCallback;
import com.iqarr.fastdfs.proto.storage.StorageDeleteFileCommand;
import com.iqarr.fastdfs.proto.storage.StorageDownloadCommand;
import com.iqarr.fastdfs.proto.storage.StorageGetMetadataCommand;
import com.iqarr.fastdfs.proto.storage.StorageQueryFileInfoCommand;
import com.iqarr.fastdfs.proto.storage.StorageSetMetadataCommand;
import com.iqarr.fastdfs.proto.storage.StorageUploadFileCommand;
import com.iqarr.fastdfs.proto.storage.StorageUploadFileSigCommand;
import com.iqarr.fastdfs.proto.storage.StorageUploadSlaveFileCommand;
import com.iqarr.fastdfs.proto.storage.enums.StorageMetdataSetType;
import com.iqarr.fastdfs.service.GenerateStorageClient;
import com.iqarr.fastdfs.service.TrackerClient;


/**
 * 
* @Title:基本存储客户端操作实现
*	 	DefaultGenerateStorageClient.java
* @Package 
*		com.iqarr.fastdfs.service.impl
* @ClassName: 
*		DefaultGenerateStorageClient  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-14:35:28
* @version 
*		V1.0
 */
public class DefaultGenerateStorageClient implements GenerateStorageClient {

    /** 日志 */
    protected static Logger LOGGER = LoggerFactory.getLogger(DefaultGenerateStorageClient.class);
    
    /** trackerClient */
    protected TrackerClient trackerClient;

    /** connectManager */
 
    protected ConnectionManager connectionManager;

    
    /**  
     * <p>Title: </p>  
     * <p>Description: </p>  
     * @param trackerClient
     * @param connectionManager  
     */
     public DefaultGenerateStorageClient(TrackerClient trackerClient) {
         super();
         this.trackerClient = trackerClient;
         this.connectionManager = new ConnectionManager();
     }
    
    
    
    /**  
    * <p>Title: </p>  
    * <p>Description: </p>  
    * @param trackerClient
    * @param connectionManager  
    */
    public DefaultGenerateStorageClient(TrackerClient trackerClient, ConnectionManager connectionManager) {
        super();
        this.trackerClient = trackerClient;
        this.connectionManager = connectionManager;
    }

   

    /**
     * 上传不支持断点续传的文件
     */
    @Override
    public StorePath uploadFile(String groupName, InputStream inputStream, long fileSize, String fileExtName) {
        StorageNode client = trackerClient.getStoreStorage(groupName);
        StorageUploadFileCommand command = new StorageUploadFileCommand(client.getStoreIndex(), inputStream,
                fileExtName, fileSize, false);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }
    /**
     * 秒传
     */
    @Override
    public StorePath uploadFileSig(String groupName, String signature, long fileSize, String prefixName,String fileExtName) {
        StorageNode client = trackerClient.getStoreStorage(groupName);
        StorageUploadFileSigCommand command =new StorageUploadFileSigCommand(client.getGroupName(), fileSize, signature, prefixName, fileExtName);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 上传从文件
     */
    @Override
    public StorePath uploadSlaveFile(String groupName, String masterFilename, InputStream inputStream, long fileSize,
            String prefixName, String fileExtName) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, masterFilename);
        StorageUploadSlaveFileCommand command = new StorageUploadSlaveFileCommand(inputStream, fileSize, masterFilename,
                prefixName, fileExtName);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 秒传 从文件
     */
    @Override
    public StorePath uploadSlaveFileSig(String groupName, String signature, String sourceFilename, long fileSize, String prefixName, String fileExtName) {
        StorageNode client = trackerClient.getStoreStorage(groupName);
        StorageUploadFileSigCommand command =new StorageUploadFileSigCommand(client.getGroupName(), fileSize, signature,sourceFilename, prefixName, fileExtName);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }
    
    /**
     * 获取metadata
     */
    @Override
    public Set<MateData> getMetadata(String groupName, String path) {
        StorageNodeInfo client = trackerClient.getFetchStorage(groupName, path);
        StorageGetMetadataCommand command = new StorageGetMetadataCommand(groupName, path);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 覆盖metadata
     */
    @Override
    public void overwriteMetadata(String groupName, String path, Set<MateData> metaDataSet) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, path);
        StorageSetMetadataCommand command = new StorageSetMetadataCommand(groupName, path, metaDataSet,
                StorageMetdataSetType.STORAGE_SET_METADATA_FLAG_OVERWRITE);
        connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 合并metadata
     */
    @Override
    public void mergeMetadata(String groupName, String path, Set<MateData> metaDataSet) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, path);
        StorageSetMetadataCommand command = new StorageSetMetadataCommand(groupName, path, metaDataSet,
                StorageMetdataSetType.STORAGE_SET_METADATA_FLAG_MERGE);
        connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 查询文件信息
     */
    @Override
    public FileInfo queryFileInfo(String groupName, String path) {
        StorageNodeInfo client = trackerClient.getFetchStorage(groupName, path);
        StorageQueryFileInfoCommand command = new StorageQueryFileInfoCommand(groupName, path);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 删除文件
     */
    @Override
    public void deleteFile(String groupName, String path) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, path);
        StorageDeleteFileCommand command = new StorageDeleteFileCommand(groupName, path);
        connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    /**
     * 下载整个文件
     */
    @Override
    public <T> T downloadFile(String groupName, String path, DownloadCallback<T> callback) {
        long fileOffset = 0;
        long fileSize = 0;
        return downloadFile(groupName, path, fileOffset, fileSize, callback);
    }

    /**
     * 下载文件片段
     */
    @Override
    public <T> T downloadFile(String groupName, String path, long fileOffset, long fileSize,
            DownloadCallback<T> callback) {
        StorageNodeInfo client = trackerClient.getFetchStorage(groupName, path);
        StorageDownloadCommand<T> command = new StorageDownloadCommand<T>(groupName, path, 0, 0, callback);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }

    public void setTrackerClientService(TrackerClient trackerClientService) {
        this.trackerClient = trackerClientService;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }



    /*
    * <p>Title: uploadFile</p>  
    * <p>Description: </p>  
    * @param groupName
    * @param file
    * @param fileSize
    * @param fileExtName
    * @return  
    * @see com.iqarr.fastdfs.service.GenerateStorageClient#uploadFile(java.lang.String, byte[], long, java.lang.String)  
    */
    
    @Override
    public StorePath uploadFile(String groupName, byte[] file, long fileSize, String fileExtName) {
        StorageNode client = trackerClient.getStoreStorage(groupName);
        StorageUploadFileCommand command = new StorageUploadFileCommand(client.getStoreIndex(), file,
                fileExtName, fileSize, false);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }



    /*
    * <p>Title: uploadSlaveFile</p>  
    * <p>Description: </p>  
    * @param groupName
    * @param masterFilename
    * @param file
    * @param fileSize
    * @param prefixName
    * @param fileExtName
    * @return  
    * @see com.iqarr.fastdfs.service.GenerateStorageClient#uploadSlaveFile(java.lang.String, java.lang.String, byte[], long, java.lang.String, java.lang.String)  
    */
    
    @Override
    public StorePath uploadSlaveFile(String groupName, String masterFilename, byte[] file, long fileSize, String prefixName, String fileExtName) {
        StorageNodeInfo client = trackerClient.getUpdateStorage(groupName, masterFilename);
        StorageUploadSlaveFileCommand command = new StorageUploadSlaveFileCommand(file, fileSize, masterFilename,
                prefixName, fileExtName);
        return connectionManager.executeFdfsCmd(client.getInetSocketAddress(), command);
    }



   



   

}
