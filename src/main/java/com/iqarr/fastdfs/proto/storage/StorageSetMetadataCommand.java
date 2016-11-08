package com.iqarr.fastdfs.proto.storage;

import java.util.Set;

import com.iqarr.fastdfs.dataobject.MateData;
import com.iqarr.fastdfs.proto.AbstractFdfsCommand;
import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.enums.StorageMetdataSetType;
import com.iqarr.fastdfs.proto.storage.internal.StorageSetMetadataRequest;


/**
 * 
* @Title:设置文件标签
*	 	StorageSetMetadataCommand.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		StorageSetMetadataCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:44:46
* @version 
*		V1.0
 */
public class StorageSetMetadataCommand extends AbstractFdfsCommand<Void> {

    /**
     * 设置文件标签(元数据)
     * 
     * @param groupName
     * @param path
     * @param metaDataSet
     * @param type
     */
    public StorageSetMetadataCommand(String groupName, String path, Set<MateData> metaDataSet,
            StorageMetdataSetType type) {
        this.request = new StorageSetMetadataRequest(groupName, path, metaDataSet, type);
        // 输出响应
        this.response = new FdfsResponse<Void>() {
            // default response
        };
    }

}
