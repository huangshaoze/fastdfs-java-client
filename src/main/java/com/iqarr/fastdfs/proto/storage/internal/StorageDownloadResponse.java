package com.iqarr.fastdfs.proto.storage.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.iqarr.fastdfs.proto.FdfsResponse;
import com.iqarr.fastdfs.proto.storage.DownloadCallback;
import com.iqarr.fastdfs.proto.storage.FdfsInputStream;




/**
 * 
* @Title: 文件下载结果
*	 	StorageDownloadResponse.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageDownloadResponse  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:31:38
* @version 
*		V1.0    
* @param <T>
 */
public class StorageDownloadResponse<T> extends FdfsResponse<T> {

    private DownloadCallback<T> callback;

    public StorageDownloadResponse(DownloadCallback<T> callback) {
        super();
        this.callback = callback;
    }

    /**
     * 解析反馈内容
     */
    @Override
    public T decodeContent(InputStream in, Charset charset) throws IOException {
        // 解析报文内容
        FdfsInputStream input = new FdfsInputStream(in, getContentLength());
        return callback.recv(input);
    }

}
