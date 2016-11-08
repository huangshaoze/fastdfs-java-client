package com.iqarr.fastdfs.pool;

import java.net.InetSocketAddress;
import java.util.List;

import com.iqarr.fastdfs.dataobject.TrackerLocator;
import com.iqarr.fastdfs.exception.FdfsConnectException;
import com.iqarr.fastdfs.proto.FdfsCommand;


/**
 * 管理TrackerClient连接池分配
* @Title:
*	 	TrackerConnectionManager.java
* @Package 
*		com.iqarr.fastdfs.pool
* @ClassName: 
*		TrackerConnectionManager  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-13:47:08
* @version 
*		V1.0
 */

public class TrackerConnectionManager extends ConnectionManager {

    /** Tracker定位 */
    private TrackerLocator trackerLocator;

    /** tracker服务配置地址列表 */
    public static  List<String> trackerList; 

    /** 构造函数 */
    public TrackerConnectionManager() {
        super();
        initTracker();
    }

    /** 构造函数 */
    public TrackerConnectionManager(FdfsConnectionPool pool) {
        ConnectionManager.pool=pool;
        initTracker();
    }

    /** 初始化方法 */
    public void initTracker() {
        LOGGER.debug("init trackerLocator {}", trackerList);
        trackerLocator = new TrackerLocator(trackerList);
    }

   
    /**
     * 
     * @Title: 
     *		executeFdfsTrackerCmd
     * @Description: 
     *		获取连接并执行
     * @param command
     * @return
     */
    public <T> T executeFdfsTrackerCmd(FdfsCommand<T> command) {
        Connection conn = null;
        InetSocketAddress address = null;
        // 获取连接
        try {
            address = trackerLocator.getTrackerAddress();
            LOGGER.debug("获取到Tracker连接地址{}", address);
            conn = getConnection(address);
            trackerLocator.setActive(address);
        } catch (FdfsConnectException e) {
            trackerLocator.setInActive(address);
            throw e;
        } catch (Exception e) {
            LOGGER.error("Unable to borrow buffer from pool", e);
            throw new RuntimeException("Unable to borrow buffer from pool", e);
        }
        // 执行
        return execute(address, conn, command);
    }

   
}
