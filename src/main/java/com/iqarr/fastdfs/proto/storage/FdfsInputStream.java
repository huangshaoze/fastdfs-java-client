package com.iqarr.fastdfs.proto.storage;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
* @Title:FdfsInputStream包装类
*	 	FdfsInputStream.java
* @Package 
*		com.iqarr.fastdfs.proto.storage
* @ClassName: 
*		FdfsInputStream  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-11:57:45
* @version 
*		V1.0
 */
public class FdfsInputStream extends InputStream {

    private final InputStream ins;
    private final long size;
    private long remainByteSize;

    public FdfsInputStream(InputStream ins, long size) {
        this.ins = ins;
        this.size = size;
        remainByteSize = size;
    }

    @Override
    public int read() throws IOException {
        return ins.read();
    }

    @Override
    public int read(byte b[], int off, int len) throws IOException {
        if (remainByteSize == 0) {
            return -1;
        }
        int byteSize = ins.read(b, off, len);
        if (remainByteSize < byteSize) {
            throw new IOException("协议长度" + size + "与实际长度不符");
        }

        remainByteSize -= byteSize;
        return byteSize;
    }

    @Override
    public void close() throws IOException {
        // do nothing
    }

    /**
     * 是否已完成读取
     * 
     * @return
     */
    public boolean isReadCompleted() {
        return remainByteSize == 0;
    }

}
