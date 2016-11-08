package com.iqarr.fastdfs.service;

import java.io.InputStream;
import java.util.Set;

import com.iqarr.fastdfs.dataobject.MateData;
import com.iqarr.fastdfs.dataobject.StorePath;



/**
 * 
* @Title:面向普通应用的文件操作接口封装
*	 	FastFileStorageClient.java
* @Package 
*		com.iqarr.fastdfs.service
* @ClassName: 
*		FastFileStorageClient  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-10:00:23
* @version 
*		V1.0
 */
public interface FastFileStorageClient extends GenerateStorageClient {

    /**
     * 上传一般文件
     * 
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @param metaDataSet
     * @return
     */
    StorePath uploadFile(InputStream inputStream, long fileSize, String fileExtName, Set<MateData> metaDataSet);

    /**
     * 上传图片并且生成缩略图
     * 
     * <pre>
     * 支持的图片格式包括"JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP"
     * </pre>
     * 
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @param metaDataSet
     * @return
     */
    StorePath uploadImageAndCrtThumbImage(InputStream inputStream, long fileSize, String fileExtName,
            Set<MateData> metaDataSet);

    /**
     * 删除文件
     * 
     * @param filePath 文件路径(groupName/path)
     */
    void deleteFile(String filePath);

}
