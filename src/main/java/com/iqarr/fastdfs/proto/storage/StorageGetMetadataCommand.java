package com.iqarr.fastdfs.proto.storage;

import java.util.Set;

import com.iqarr.fastdfs.dataobject.MateData;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.storage.internal.StorageGetMetadataRequest;
import com.iqarr.fastdfs.proto.storage.internal.StorageGetMetadataResponse;


/**
 * 
* @Title:设置文件标签
*	 	StorageGetMetadataCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageGetMetadataCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:44:07
* @version 
*		V1.0
 */
public class StorageGetMetadataCommand extends AbstractFdfsCommand<Set<MateData>> {

    /**
     * 设置文件标签(元数据)
     * 
     * @param groupName
     * @param path
     * @param metaDataSet
     * @param type
     */
    public StorageGetMetadataCommand(String groupName, String path) {
        this.request = new StorageGetMetadataRequest(groupName, path);
        // 输出响应
        this.response = new StorageGetMetadataResponse();
    }

}
