package com.iqarr.fastdfs.pool;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.iqarr.fastdfs.constants.FastdfsSystemConfig;



/**
 * 定义了被池化的对象的创建，初始化，激活，钝化以及销毁功能
* @Title:
*	 	PooledConnectionFactory.java
* @Package 
*		com.iqarr.fastdfs.pool
* @ClassName: 
*		PooledConnectionFactory  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-10:44:44
* @version 
*		V1.0
 */
public class PooledConnectionFactory extends BaseKeyedPooledObjectFactory<InetSocketAddress, Connection> {

    /** 读取时间 */
    private int soTimeout;
    /** 连接超时时间 */
    private int connectTimeout;
    /** 字符集 */
    private Charset charset;
   
    /** 设置默认字符集 */
    private String charsetName = FastdfsSystemConfig.FASTDFS_CHARSET;

    /**
     * 创建连接
     */
    @Override
    public Connection create(InetSocketAddress address) throws Exception {
        // 初始化字符集
        if (null == charset) {
            charset = Charset.forName(charsetName);
        }
        return new DefaultConnection(address, soTimeout, connectTimeout, charset);
    }

    /**
     * 
     * 用Connection封装对象放入池中
     */
    @Override
    public PooledObject<Connection> wrap(Connection conn) {
        return new DefaultPooledObject<Connection>(conn);
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Charset getCharset() {
        return charset;
    }

    @Override
    public void destroyObject(InetSocketAddress key, PooledObject<Connection> p) throws Exception {
        p.getObject().close();
    }

    /**
     * 验证是否在使用
     */
    @Override
    public boolean validateObject(InetSocketAddress key, PooledObject<Connection> p) {
        return p.getObject().isValid();
    }

    public void setCharsetName(String charsetName) {
        this.charsetName = charsetName;
    }

}
