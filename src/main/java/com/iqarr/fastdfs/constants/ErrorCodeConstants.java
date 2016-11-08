package com.iqarr.fastdfs.constants;


/**
 * 
* @Title:fastdfs协议错误码的常量
*	 	ErrorCodeConstants.java
* @Package 
*		com.iqarr.fastdfs.proto
* @ClassName: 
*		ErrorCodeConstants  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-11:47:44
* @version 
*		V1.0
 */
public final class ErrorCodeConstants {

    public static final byte SUCCESS = 0;
    public static final byte ERR_NO_ENOENT = 2;
    public static final byte ERR_NO_EIO = 5;
    public static final byte ERR_NO_EBUSY = 16;
    public static final byte ERR_NO_EINVAL = 22;
    public static final byte ERR_NO_ENOSPC = 28;
    public static final byte ERR_NO_CONNREFUSED = 61;
    public static final byte ERR_NO_EALREADY = 114;
    /**秒传主文件不存在 **/
    public static final byte ERR_SIG_FILE_NOT_FIND=-1;
    /** 上传从文件以存在**/
    public static final byte ERR_SIG_FILE_SLAVE_EXIT=17;

}
