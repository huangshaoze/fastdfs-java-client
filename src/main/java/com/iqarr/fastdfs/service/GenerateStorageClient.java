package com.iqarr.fastdfs.service;

import java.io.InputStream;
import java.util.Set;

import com.iqarr.fastdfs.dataobject.FileInfo;
import com.iqarr.fastdfs.dataobject.MateData;
import com.iqarr.fastdfs.dataobject.StorePath;
import com.iqarr.fastdfs.proto.storage.DownloadCallback;



/**
 * 
* @Title:基本文件存储客户端操作
*	 	GenerateStorageClient.java
* @Package 
*		com.iqarr.fastdfs.service
* @ClassName: 
*		GenerateStorageClient  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-10:00:08
* @version 
*		V1.0
 */
public interface GenerateStorageClient {

    /**
     * 上传文件(文件不可修改)
     * 
     * <pre>
     * 文件上传后不可以修改，如果要修改则删除以后重新上传
     * </pre>
     * 
     * @param groupName
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @return
     */
    StorePath uploadFile(String groupName, InputStream inputStream, long fileSize, String fileExtName);
    
   
    /**
     * 
     * @Title: 
     *		uploadFileSig
     * @Description: 
     *		上传文件秒传 如果结果为null  表示文件不存在
     *      　　　文件上传后不可以修改，如果要修改则删除以后重新上传
     * @param groupName　　组名称　注意通过该组名称判断需要上传的地址,所以秒传只是在同组内使用
     * @param signature　　　签名　48位　不足0前面填充  md5 $hash
     * @param fileSize   文件大小
     * @param prefixName　　　前缀名称　不能为空
     * @param fileExtName　　后缀
     * @return
     */
    StorePath uploadFileSig(String groupName, String signature, long fileSize,String prefixName, String fileExtName);

    /**
     * 上传从文件
     * 
     * @param groupName
     * @param masterFilename
     * @param inputStream
     * @param fileSize
     * @param prefixName
     * @param fileExtName
     * @return
     */
    StorePath uploadSlaveFile(String groupName, String masterFilename, InputStream inputStream, long fileSize,
            String prefixName, String fileExtName);

    /**
     * 
     * @Title: 
     *      uploadFileSig
     * @Description: 
     *      上传文件秒传从文件 如果结果为null  表示文件不存在
     *      　　　文件上传后不可以修改，如果要修改则删除以后重新上传
     * @param groupName　　组名称 注意通过该组名称判断需要上传的地址,所以秒传只是在同组内使用
     * @param signature　　　签名　48位　不足0前面填充  md5 $hash
     * @param sourceFilename  主文件id   00/00/wKgCIVfl0ymAYjk4AAAIACB29dM 或者M00/00/00/wKgC3lgJwWuAMSDoAAmSRnaGOfo122aaa.jpg
     * @param fileSize   文件大小
     * @param prefixName　　　前缀名称　不能为空
     * @param fileExtName　　后缀
     * @return
     */
    StorePath uploadSlaveFileSig(String groupName, String signature,String sourceFilename, long fileSize,String prefixName, String fileExtName);
    
    /**
     * 获取文件元信息
     * 
     * @param groupName
     * @param path
     * @return
     */
    Set<MateData> getMetadata(String groupName, String path);

    /**
     * 修改文件元信息（覆盖）
     * 
     * @param groupName
     * @param path
     * @param metaDataSet
     */
    void overwriteMetadata(String groupName, String path, Set<MateData> metaDataSet);

    /**
     * 修改文件元信息（合并）
     * 
     * @param groupName
     * @param path
     * @param metaDataSet
     */
    void mergeMetadata(String groupName, String path, Set<MateData> metaDataSet);

    /**
     * 查看文件的信息
     * 
     * @param groupName
     * @param path
     * @return
     */
    FileInfo queryFileInfo(String groupName, String path);

    /**
     * 删除文件
     * 
     * @param groupName
     * @param path
     */
    void deleteFile(String groupName, String path);

    /**
     * 下载整个文件
     * 
     * @param groupName
     * @param path
     * @param callback
     * @return
     */
    <T> T downloadFile(String groupName, String path, DownloadCallback<T> callback);

    /**
     * 下载文件片段
     * 
     * @param groupName
     * @param path
     * @param fileOffset
     * @param fileSize
     * @param callback
     * @return
     */
    <T> T downloadFile(String groupName, String path, long fileOffset, long fileSize, DownloadCallback<T> callback);

}
