package com.iqarr.fastdfs.dataobject;

import java.net.InetSocketAddress;

import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;



/**向tracker请求上传、下载文件或其他文件请求时，tracker返回的文件storage节点的信息
 * 
* @Title:
*	 	StorageNodeInfo.java
* @Package 
*		com.iqarr.fastdfs.dataobject
* @ClassName: 
*		StorageNodeInfo  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/23-13:52:05
* @version 
*		V1.0
 */
public class StorageNodeInfo {

    @FastdfsColumn(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;
    @FastdfsColumn(index = 1, max = OtherConstants.FDFS_IPADDR_SIZE - 1)
    private String ip;
    @FastdfsColumn(index = 2)
    private int port;

    /**
     * 存储节点
     * 
     * @param ip
     * @param port
     * @param storeIndex
     */
    public StorageNodeInfo(String ip, int port) {
        super();
        this.ip = ip;
        this.port = port;
    }

    public StorageNodeInfo() {
        super();
    }

    /**
     * @return the inetSocketAddress
     */
    public InetSocketAddress getInetSocketAddress() {
        return new InetSocketAddress(ip, port);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "StorageClientInfo [groupName=" + groupName + ", ip=" + ip + ", port=" + port + "]";
    }

}
