package com.iqarr.fastdfs.exception;

/**
 * 封装fastdfs的异常，使用运行时异常
* @Title:
*	 	FdfsException.java
* @Package 
*		com.iqarr.fastdfs.exception
* @ClassName: 
*		FdfsException  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-10:39:43
* @version 
*		V1.0
 */
public abstract class FdfsException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    protected FdfsException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    protected FdfsException(String message, Throwable cause) {
        super(message, cause);
    }

}
