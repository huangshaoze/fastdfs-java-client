package com.iqarr.fastdfs.proto;

import com.iqarr.fastdfs.pool.Connection;


/**
 * 
* @Title:Fdfs执行命令抽象
*	 	FdfsCommand.java
* @Package 
*		com.iqarr.fastdfs.proto
* @ClassName: 
*		FdfsCommand  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/26-15:21:41
* @version 
*		V1.0    
* @param <T>
 */
public interface FdfsCommand<T> {

    /** 执行交易 */
    public T execute(Connection conn);

}
