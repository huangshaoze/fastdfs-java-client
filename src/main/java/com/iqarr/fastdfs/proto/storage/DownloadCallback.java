package com.iqarr.fastdfs.proto.storage;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
* @Title:文件下载回调接口
*	 	DownloadCallback.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		DownloadCallback  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-11:57:22
* @version 
*		V1.0    
* @param <T>
 */
public interface DownloadCallback<T> {

    /**
     * 注意不能直接返回入参的InputStream，因为此方法返回后将关闭原输入流
     * 
     * 不能关闭ins? TODO验证是否可以关闭
     * 
     * @param ins
     * @throws IOException
     * @return
     */
    T recv(InputStream ins) throws IOException;

}
