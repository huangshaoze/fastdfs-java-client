package com.iqarr.fastdfs.exception;


/**
 * 映射异常
* @Title:
*	 	FdfsColumnMapException.java
* @Package 
*		com.iqarr.fastdfs.mapperfactory
* @ClassName: 
*		FdfsColumnMapException  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/23-13:46:46
* @version 
*		V1.0
 */
public class FdfsColumnMapException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1336200127024129847L;

    protected FdfsColumnMapException() {
    }

    protected FdfsColumnMapException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    protected FdfsColumnMapException(String message, Throwable cause) {
        super(message, cause);
    }

    public FdfsColumnMapException(String message) {
        super(message);
    }

    public FdfsColumnMapException(Throwable cause) {
        super(cause);
    }

}
