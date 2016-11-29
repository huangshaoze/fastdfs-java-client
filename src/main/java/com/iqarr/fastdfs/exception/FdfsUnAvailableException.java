package com.iqarr.fastdfs.exception;


/**
 * 
* @Title:非fastdfs本身的错误码抛出的异常，取服务端连接取不到时抛出的异常
*	 	FdfsUnAvailableException.java
* @Package 
*		com.iqarr.fastdfs.exception
* @ClassName: 
*		FdfsUnAvailableException  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/11/29-10:52:07
* @version 
*		V1.0
 */
public class FdfsUnAvailableException extends FdfsException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public FdfsUnAvailableException(String message) {
        super("无法获取服务端连接资源：" + message);
    }

    /**
     * @param message
     */
    public FdfsUnAvailableException(String message, Throwable t) {
        super("无法获取服务端连接资源：" + message, t);
    }

}
