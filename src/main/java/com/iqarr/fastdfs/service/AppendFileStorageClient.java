package com.iqarr.fastdfs.service;

import java.io.InputStream;

import com.iqarr.fastdfs.dataobject.StorePath;


/**
 * 
 *  支持断点续传的文件服务接口
 * 
 * <pre>
 * 适合处理大文件，分段传输
* @Title:
*	 	AppendFileStorageClient.java
* @Package 
*		com.iqarr.fastdfs.service
* @ClassName: 
*		AppendFileStorageClient  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-10:06:40
* @version 
*		V1.0
 */
public interface AppendFileStorageClient extends GenerateStorageClient {

    /**
     * 上传支持断点续传的文件
     * 
     * @param groupName
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @return
     */
    StorePath uploadAppenderFile(String groupName, InputStream inputStream, long fileSize, String fileExtName);

    /**
     * 断点续传文件
     * 
     * @param groupName
     * @param path
     * @param inputStream
     * @param fileSize
     */
    void appendFile(String groupName, String path, InputStream inputStream, long fileSize);

    /**
     * 修改续传文件的内容
     * 
     * @param groupName
     * @param path
     * @param inputStream
     * @param fileSize
     * @param fileOffset
     */
    void modifyFile(String groupName, String path, InputStream inputStream, long fileSize, long fileOffset);

    /**
     * 清除续传类型文件的内容
     * 
     * @param groupName
     * @param path
     * @param truncatedFileSize
     */
    void truncateFile(String groupName, String path, long truncatedFileSize);

    /**
     * 清除续传类型文件的内容
     * 
     * @param groupName
     * @param path
     */
    void truncateFile(String groupName, String path);

}
