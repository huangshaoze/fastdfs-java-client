package com.iqarr.fastdfs.proto.storage.enums;

/**
 * 
* @Title:元数据设置方式
*	 	StorageMetdataSetType.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.enums
* @ClassName: 
*		StorageMetdataSetType  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:35:52
* @version 
*		V1.0
 */
public enum StorageMetdataSetType {

    /** 覆盖 */
    STORAGE_SET_METADATA_FLAG_OVERWRITE((byte) 'O'),
    /** 没有的条目增加，有则条目覆盖 */
    STORAGE_SET_METADATA_FLAG_MERGE((byte) 'M');

    private byte type;

    private StorageMetdataSetType(byte type) {
        this.type = type;
    }

    public byte getType() {
        return type;
    }

}
