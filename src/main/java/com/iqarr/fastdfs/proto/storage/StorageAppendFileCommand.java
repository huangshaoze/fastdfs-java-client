package com.iqarr.fastdfs.proto.storage;

import java.io.InputStream;

import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.internal.StorageAppendFileRequest;

/**
 * 
* @Title:添加文件命令
*	 	StorageAppendFileCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageAppendFileCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:42:13
* @version 
*		V1.0
 */
public class StorageAppendFileCommand extends AbstractFdfsCommand<Void> {

    public StorageAppendFileCommand(InputStream inputStream, long fileSize, String path) {
        this.request = new StorageAppendFileRequest(inputStream, fileSize, path);
        // 输出响应
        this.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
