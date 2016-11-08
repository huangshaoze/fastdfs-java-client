package com.iqarr.fastdfs.proto;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.lang.reflect.ParameterizedType;
import com.iqarr.fastdfs.mapperfactory.FdfsParamMapperFactory;


/**
 * 
* @Title:Fdfs交易应答基类
*	 	FdfsResponse.java
* @Package 
*		com.iqarr.fastdfs.proto
* @ClassName: 
*		FdfsResponse  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-11:48:33
* @version 
*		V1.0    
* @param <T>
 */
public abstract class FdfsResponse<T> {
    /** 报文头 */
    protected ProtoHead head;

    /** 返回值类型 */
    protected final Class<T> genericType;

    /** 获取报文长度 */
    protected long getContentLength() {
        return head.getContentLength();
    }

    /**
     * 构造函数
     * 
     * 
     */
    @SuppressWarnings("unchecked")
    public FdfsResponse() {
        super();
        //this.genericType =  (Class<T>)((ParameterizedType))
                         //(Class<T>) ((ParameterizedType) getClass() ;//.getGenericSuperclass()).getActualTypeArguments()[0];
         //(Class<T>) ((ParameterizedType) getClass()
        // .getGenericSuperclass()).getActualTypeArguments()[0]
        this.genericType = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        
    }

    /**
     * 解析反馈结果,head已经被解析过
     * 
     * @param head
     * @param in
     * @param charset
     * @return
     * @throws IOException
     */
    public T decode(ProtoHead head, InputStream in, Charset charset) throws IOException {
        this.head = head;
        return decodeContent(in, charset);
    }

    /**
     * 解析反馈内容
     * 
     * @param in
     * @param charset
     * @return
     * @throws IOException
     */
    public T decodeContent(InputStream in, Charset charset) throws IOException {
        // 如果有内容
        if (getContentLength() > 0) {
            byte[] bytes = new byte[(int) getContentLength()];
            int contentSize = in.read(bytes);
            // 获取数据
            if (contentSize != getContentLength()) {
                throw new IOException("读取到的数据长度与协议长度不符");
            }
            return FdfsParamMapperFactory.map(bytes, genericType, charset);
        }
        return null;
    }

}
