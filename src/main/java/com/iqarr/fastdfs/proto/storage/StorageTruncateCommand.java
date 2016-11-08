package com.iqarr.fastdfs.proto.storage;

import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.internal.StorageTruncateRequest;


/**
 * 
* @Title:文件Truncate命令
*	 	StorageTruncateCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageTruncateCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:44:59
* @version 
*		V1.0
 */
public class StorageTruncateCommand extends AbstractFdfsCommand<Void> {

    /**
     * 文件Truncate命令
     * 
     * @param groupName
     * @param path
     */
    public StorageTruncateCommand(String path, long fileSize) {
        super();
        this.request = new StorageTruncateRequest(path, fileSize);
        // 输出响应
        this.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
