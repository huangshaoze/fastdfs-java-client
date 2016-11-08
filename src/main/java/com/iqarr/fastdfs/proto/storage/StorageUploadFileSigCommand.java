package com.iqarr.fastdfs.proto.storage;

import com.iqarr.fastdfs.dataobject.StorePath;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.internal.StorageUploadFileSigRequest;


/**
 * 
* @Title:文件上传　秒传
*	 	StorageUploadFileSigCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageUploadFileSigCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/29-11:03:56
* @version 
*		V1.0
 */
public class StorageUploadFileSigCommand extends AbstractFdfsCommand<StorePath> {

    /**
     * 
    * <p>Title: 构造通过md5&hash 秒传</p>  
    * <p>Description: </p>  
    * @param storeIndex
    * @param fileSize
    * @param signature
    * @param prefixName　前缀
    * @param fileExtName　后缀
     */
    public StorageUploadFileSigCommand(String groupName,  long fileSize, String signature,
                    String prefixName, String fileExtName) {
        super();
        this.request = new StorageUploadFileSigRequest( groupName, fileSize,signature, prefixName, fileExtName);
        // 输出响应
        this.response = new FdfsResponse<StorePath>() {
            // default response
        };
    }
    
    /**
     * 
    * <p>Title:秒传从文件 </p>  
    * <p>Description: </p>  
    * @param groupName
    * @param fileSize
    * @param signature 签名
    * @param sourceFilename  主文件id
    * @param prefixName 前缀名称
    * @param fileExtName  后缀
     */
    public StorageUploadFileSigCommand(String groupName,  long fileSize, String signature,String sourceFilename,
                    String prefixName, String fileExtName) {
        super();
        this.request = new StorageUploadFileSigRequest( groupName, fileSize,signature,sourceFilename, prefixName, fileExtName);
        // 输出响应
        this.response = new FdfsResponse<StorePath>() {
            // default response
        };
    }

}
