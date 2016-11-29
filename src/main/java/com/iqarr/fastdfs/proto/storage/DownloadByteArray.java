package com.iqarr.fastdfs.proto.storage;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

/**
 * 
* @Title:下载为byte流
*	 	DownloadByteArray.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		DownloadByteArray  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-11:57:07
* @version 
*		V1.0
 */
public class DownloadByteArray implements DownloadCallback<byte[]> {

    @Override
    public byte[] recv(InputStream ins) throws IOException {
        return IOUtils.toByteArray(ins);
    }
}
