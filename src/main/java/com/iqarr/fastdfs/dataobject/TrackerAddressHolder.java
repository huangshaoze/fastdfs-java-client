package com.iqarr.fastdfs.dataobject;

import java.net.InetSocketAddress;


/**
 * 管理TrackerAddress当前状态
* @Title:
*	 	TrackerAddressHolder.java
* @Package 
*		com.iqarr.fastdfs.dataobject
* @ClassName: 
*		TrackerAddressHolder  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-13:35:07
* @version 
*		V1.0
 */
public class TrackerAddressHolder {
    /** 连接地址 */
    private InetSocketAddress address;
    /** 当前是否有效 */
    private boolean available;
    /** 上次无效时间 */
    private long lastUnavailableTime;

    public TrackerAddressHolder(InetSocketAddress address) {
        super();
        this.address = address;
        // 默认Tracker有效
        this.available = true;
    }

   /**
    * 
    * @Title: 
    *		setActive
    * @Description: 
    *		设置有效
    */
    public void setActive() {
        this.available = true;
    }
/**
 * 
 * @Title: 
 *		setInActive
 * @Description: 
 *		设置无效
 */
    public void setInActive() {
        this.available = false;
        this.lastUnavailableTime = System.currentTimeMillis();
    }

    public boolean isAvailable() {
        return available;
    }

    public long getLastUnavailableTime() {
        return lastUnavailableTime;
    }

 
    /**
     * 
     * @Title: 
     *		canTryToConnect
     * @Description: 
     *		是否可以尝试连接 
     * @param retryAfterSecend 在n秒后重试
     * @return
     */
    public boolean canTryToConnect(int retryAfterSecend) {
        // 如果是有效连接
        if (this.available) {
            return true;
            // 如果连接无效，并且达到重试时间
        } else if ((System.currentTimeMillis() - lastUnavailableTime) > retryAfterSecend * 1000) {
            return true;
        }
        return false;
    }

    public InetSocketAddress getAddress() {
        return address;
    }

}
