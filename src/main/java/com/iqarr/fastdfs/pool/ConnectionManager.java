package com.iqarr.fastdfs.pool;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iqarr.fastdfs.exception.FdfsException;
import com.iqarr.fastdfs.proto.FdfsCommand;



/**
 *  连接池管理
 *  <pre>
 * 负责借出连接，在连接上执行业务逻辑，然后归还连
 * </pre>
* @Title:
*	 	ConnectionManager.java
* @Package 
*		com.iqarr.fastdfs.com.pool
* @ClassName: 
*		ConnectionManager  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-10:40:15
* @version 
*		V1.0
 */
public class ConnectionManager {

 
    /**连接池 **/
    public static  FdfsConnectionPool pool;
    /** 日志 */
    protected static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManager.class);

  
    public ConnectionManager() {
        super();
    }

    
   

    /**
     * 获取连接并执行
     * 
     * @param address
     * @param command
     * @return
     */
    public <T> T executeFdfsCmd(InetSocketAddress address, FdfsCommand<T> command) {

        // 获取连接
        Connection conn = getConnection(address);
        // 执行
        return execute(address, conn, command);

    }

    /**
     * 执行
     * 
     * @param conn
     * @param command
     * @return
     */
    protected <T> T execute(InetSocketAddress address, Connection conn, FdfsCommand<T> command) {
        try {
            // 执行
            LOGGER.debug("对地址{}发出请求{}", address, command.getClass().getSimpleName());
            return command.execute(conn);
        } catch (FdfsException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error("execute fdfs command error", e);
            throw new RuntimeException("execute fdfs command error", e);
        } finally {
            try {
                if (null != conn) {
                    pool.returnObject(address, conn);
                }
            } catch (Exception e) {
                LOGGER.error("return pooled connection error", e);
            }
        }
    }

    /**
     * 获取连接
     * 
     * @param address
     * @return
     */
    protected Connection getConnection(InetSocketAddress address) {
        Connection conn = null;
        try {
            // 获取连接
            conn = pool.borrowObject(address);
        } catch (FdfsException e) {
            throw e;
        } catch (Exception e) {
          
            LOGGER.error("Unable to borrow buffer from pool", e);
            throw new RuntimeException("Unable to borrow buffer from pool", e);
        }
        return conn;
    }

    public FdfsConnectionPool getPool() {
        return pool;
    }

  

    public void dumpPoolInfo(InetSocketAddress address) {

        LOGGER.debug("==============Dump Pool Info================");
        LOGGER.debug("活动连接{}", pool.getNumActive(address));
        LOGGER.debug("空闲连接{}", pool.getNumIdle(address));
        LOGGER.debug("连接获取总数统计{}", pool.getBorrowedCount());
        LOGGER.debug("连接返回总数统计{}", pool.getReturnedCount());
        LOGGER.debug("连接销毁总数统计{}", pool.getDestroyedCount());

    }

}
