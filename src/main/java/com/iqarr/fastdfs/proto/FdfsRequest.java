package com.iqarr.fastdfs.proto;

import java.io.InputStream;
import java.nio.charset.Charset;

import com.iqarr.fastdfs.mapperfactory.FdfsParamMapperFactory;
import com.iqarr.fastdfs.mapperfactory.ObjectMateData;




/**
 * 
* @Title:Fdfs交易请求基类
*	 	FdfsRequest.java
* @Package 
*		com.iqarr.fastdfs.proto
* @ClassName: 
*		FdfsRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/26-15:22:05
* @version 
*		V1.0
 */
public abstract class FdfsRequest {

    /** 报文头 */
    protected ProtoHead head;
    /** 发送文件 */
    protected InputStream inputFile;
    /**  文件byte 先检查inpuStreame 在使用byte **/
    protected byte [] file;

    /**
     * 获取报文头(包内可见)
     * 
     * @return
     */
    ProtoHead getHead() {
        return head;
    }

    /**
     * 获取报文头
     * 
     * @param charset
     * @return
     */
    public byte[] getHeadByte(Charset charset) {
        // 设置报文长度
        head.setContentLength(getBodyLength(charset));
        // 返回报文byte
        return head.toByte();
    }

    /**
     * 打包参数
     * 
     * @param charset
     * @return
     */
    public byte[] encodeParam(Charset charset) {
        return FdfsParamMapperFactory.toByte(this, charset);
    }

    /**
     * 获取参数域长度
     * 
     * @return
     */
    protected long getBodyLength(Charset charset) {
        ObjectMateData objectMateData = FdfsParamMapperFactory.getObjectMap(this.getClass());
        return objectMateData.getFieldsSendTotalByteSize(this, charset) + getFileSize();
    }

    public InputStream getInputFile() {
        return inputFile;
    }

    public long getFileSize() {
        return 0;
    }

    /**
     * 获取 文件byte 先检查inpuStreame 在使用byte 
     * @return file
     */
    public byte[] getFile() {
        return file;
    }

    /**
     * 设置 文件byte 先检查inpuStreame 在使用byte
     * @param file 文件byte 先检查inpuStreame 在使用byte
     */
    public void setFile(byte[] file) {
        this.file = file;
    }

    
    
}
