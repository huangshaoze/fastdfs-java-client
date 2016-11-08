package com.iqarr.fastdfs.dataobject;

import java.net.InetSocketAddress;

import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;



/**
 * 向tracker请求上传、下载文件或其他文件请求时，tracker返回的文件storage节点的信息
* @Title:
*	 	StorageNode.java
* @Package 
*		com.iqarr.fastdfs.dataobject
* @ClassName: 
*		StorageNode  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-14:47:57
* @version 
*		V1.0
 */
public class StorageNode {

    @FastdfsColumn(index = 0, max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupName;
    @FastdfsColumn(index = 1, max = OtherConstants.FDFS_IPADDR_SIZE - 1)
    private String ip;
    @FastdfsColumn(index = 2)
    private int port;
    @FastdfsColumn(index = 3)
    private byte storeIndex;

    /**
     * 存储节点
     * 
     * @param ip
     * @param port
     * @param storeIndex
     */
    public StorageNode(String ip, int port, byte storeIndex) {
        super();
        this.ip = ip;
        this.port = port;
        this.storeIndex = storeIndex;
    }

    public StorageNode() {
        super();
    }

    /**
     * @return the inetSocketAddress
     */
    public InetSocketAddress getInetSocketAddress() {
        return new InetSocketAddress(ip, port);
    }

    /**
     * @return the storeIndex
     */
    public byte getStoreIndex() {
        return storeIndex;
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

    public void setStoreIndex(byte storeIndex) {
        this.storeIndex = storeIndex;
    }

    @Override
    public String toString() {
        return "StorageClient [groupName=" + groupName + ", ip=" + ip + ", port=" + port + ", storeIndex=" + storeIndex
                + "]";
    }

}
