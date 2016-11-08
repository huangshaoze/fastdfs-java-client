package com.iqarr.fastdfs.proto.storage.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Set;

import com.iqarr.fastdfs.dataobject.MateData;
import com.iqarr.fastdfs.mapperfactory.MetadataMapper;
import com.iqarr.fastdfs.proto.FdfsResponse;


/**
 * 
* @Title:列出分组信息执行结果
*	 	StorageGetMetadataResponse.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageGetMetadataResponse  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/28-13:32:49
* @version 
*		V1.0
 */
public class StorageGetMetadataResponse extends FdfsResponse<Set<MateData>> {

    /**
     * 解析反馈内容
     */
    @Override
    public Set<MateData> decodeContent(InputStream in, Charset charset) throws IOException {
        // 解析报文内容
        byte[] bytes = new byte[(int) getContentLength()];
        int contentSize = in.read(bytes);
        if (contentSize != getContentLength()) {
            throw new IOException("读取到的数据长度与协议长度不符");
        }
        return MetadataMapper.fromByte(bytes, charset);

    }

}
