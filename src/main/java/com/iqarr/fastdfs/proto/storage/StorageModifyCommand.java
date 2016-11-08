package com.iqarr.fastdfs.proto.storage;

import java.io.InputStream;

import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.internal.StorageModifyRequest;


/**
 * 
* @Title:文件修改命令
*	 	StorageModifyCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageModifyCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:44:21
* @version 
*		V1.0
 */
public class StorageModifyCommand extends AbstractFdfsCommand<Void> {

    /**
     * 文件修改命令
     * 
     * @param path
     * @param inputStream
     * @param fileSize
     * @param fileOffset
     */
    public StorageModifyCommand(String path, InputStream inputStream, long fileSize, long fileOffset) {
        super();
        this.request = new StorageModifyRequest(inputStream, fileSize, path, fileOffset);
        // 输出响应
        this.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
