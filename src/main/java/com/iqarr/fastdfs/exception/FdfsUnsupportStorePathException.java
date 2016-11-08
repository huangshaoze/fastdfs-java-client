package com.iqarr.fastdfs.exception;


/**
 * 从Url解析StorePath文件路径错误
* @Title:
*	 	FdfsUnsupportStorePathException.java
* @Package 
*		com.iqarr.fastdfs.exception
* @ClassName: 
*		FdfsUnsupportStorePathException  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/23-12:00:29
* @version 
*		V1.0
 */
public class FdfsUnsupportStorePathException extends FdfsException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8116336411011152869L;

    public FdfsUnsupportStorePathException(String message) {
        super(message);
    }

}
