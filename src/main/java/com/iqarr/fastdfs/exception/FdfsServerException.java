package com.iqarr.fastdfs.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.iqarr.fastdfs.constants.ErrorCodeConstants;




/**
 * 
* @Title:fastdfs服务端返回的错误码构成的异常
*	 	FdfsServerException.java
* @Package 
*		com.iqarr.fastdfs.exception
* @ClassName: 
*		FdfsServerException  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/11/08-08:49:15
* @version 
*		V1.0
 */
public class FdfsServerException extends FdfsException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** 错误对照表 */
    private static final Map<Integer, String> CODE_MESSAGE_MAPPING;

    static {
        Map<Integer, String> mapping = new HashMap<Integer, String>();
        mapping.put((int) ErrorCodeConstants.ERR_NO_ENOENT, "找不到节点或文件");
        mapping.put((int) ErrorCodeConstants.ERR_NO_EIO, "服务端发生io异常");
        mapping.put((int) ErrorCodeConstants.ERR_NO_EINVAL, "无效的参数");
        mapping.put((int) ErrorCodeConstants.ERR_NO_EBUSY, "服务端忙");
        mapping.put((int) ErrorCodeConstants.ERR_NO_ENOSPC, "没有足够的存储空间");
        mapping.put((int) ErrorCodeConstants.ERR_NO_CONNREFUSED, "服务端拒绝连接");
        mapping.put((int) ErrorCodeConstants.ERR_NO_EALREADY, "文件已经存在？");
        mapping.put((int) ErrorCodeConstants.ERR_SIG_FILE_NOT_FIND, "秒传文件不存在？");
        mapping.put((int) ErrorCodeConstants.ERR_SIG_FILE_SLAVE_EXIT, "上传从文件以存在？");
        CODE_MESSAGE_MAPPING = Collections.unmodifiableMap(mapping);
    }

    private int errorCode;

    /**
     * 
     */
    private FdfsServerException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public static FdfsServerException byCode(int errorCode) {
        String message = CODE_MESSAGE_MAPPING.get(errorCode);
        if (message == null) {
            message = "未知错误";
        }
        message = "错误码：" + errorCode + "，错误信息：" + message;

        return new FdfsServerException(errorCode, message);
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

}
