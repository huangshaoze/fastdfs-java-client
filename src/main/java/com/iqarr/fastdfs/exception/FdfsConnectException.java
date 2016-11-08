package com.iqarr.fastdfs.exception;


/**
 * 
* @Title:非fastdfs本身的错误码抛出的异常，socket连不上时抛出的异常
*	 	FdfsConnectException.java
* @Package 
*		com.iqarr.fastdfs.exception
* @ClassName: 
*		FdfsConnectException  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/11/08-08:49:01
* @version 
*		V1.0
 */
public class FdfsConnectException extends FdfsUnAvailableException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public FdfsConnectException(String message, Throwable t) {
        super(message, t);
    }

}
