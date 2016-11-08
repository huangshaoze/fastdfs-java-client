package com.iqarr.fastdfs.pool;

import java.net.InetSocketAddress;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;



/**
 * fafsdfs对象连接池
* @Title:
*	 	FdfsConnectionPool.java
* @Package 
*		com.iqarr.fastdfs.com.pool
* @ClassName: 
*		FdfsConnectionPool  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-10:29:52
* @version 
*		V1.0
 */
public class FdfsConnectionPool extends GenericKeyedObjectPool<InetSocketAddress, Connection> {

    /**
     * 
    * <p>Title: </p>  
    * <p>Description: </p>  
    * @param factory
    * @param config
     */
    public FdfsConnectionPool(KeyedPooledObjectFactory<InetSocketAddress, Connection> factory,
            GenericKeyedObjectPoolConfig config) {
        super(factory, config);
    }

    /**
     * 
    * <p>Title: </p>  
    * <p>Description: </p>  
    * @param factory
     */
    public FdfsConnectionPool(KeyedPooledObjectFactory<InetSocketAddress, Connection> factory) {
        super(factory);
    }

}
