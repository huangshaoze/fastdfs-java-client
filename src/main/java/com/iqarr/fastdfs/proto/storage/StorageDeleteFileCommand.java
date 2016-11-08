package com.iqarr.fastdfs.proto.storage;

import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.internal.StorageDeleteFileRequest;


/**
 * 
* @Title:文件删除命令
*	 	StorageDeleteFileCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageDeleteFileCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:43:35
* @version 
*		V1.0
 */
public class StorageDeleteFileCommand extends AbstractFdfsCommand<Void> {

    /**
     * 文件删除命令
     * 
     * @param storeIndex 存储节点
     * @param inputStream 输入流
     * @param fileExtName 文件扩展名
     * @param size 文件大小
     * @param isAppenderFile 是否添加模式
     */
    public StorageDeleteFileCommand(String groupName, String path) {
        super();
        this.request = new StorageDeleteFileRequest(groupName, path);
        // 输出响应
        this.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
