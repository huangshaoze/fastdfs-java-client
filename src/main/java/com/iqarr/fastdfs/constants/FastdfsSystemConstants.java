package com.iqarr.fastdfs.constants;
/**
 * 系统常量配置
 * 允许修改
* @Title:
*	 	FastdfsSystemConstants.java
* @Package 
*		com.iqarr.fastdfs.constants
* @ClassName: 
*		FastdfsSystemConstants  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-13:38:10
* @version 
*		V1.0
 */
public class FastdfsSystemConstants {
    /** 默认字符集 */
  //  public static  String DEFAULT_CHARSET_NAME = "UTF-8";
    
    /**tracker重试连接 10分钟以后重试连接 */
    public static  int DEFAULT_TRACKER_RETRY_AFTER_SECEND = 10 * 60;
    /** 最大配置tracert服务器数量*/
    public static final  int MAX_TRACERT_NUMBER=1204; 
    
    /** 基础配置文件名称 */
    public static  final String CONFIG_FILE_NAME="fastdfs.properties";
    /** 编码 */
    public static final String CONFIG_FILE_KEY_CHARSET="fastdfs.defult.charset.name";
    /**tracker 服务器  */
    public static final String CONFIG_FILE_KEY_TRACKERLIST="fastdfs.trackerList.";
    /** 连接超时 */
    public static final String CONFIG_FILE_KEY_CONNECTTIMEOUT="fastdfs.connectTimeout";
    /** 连接tracker超时重试时间 */
    public static final String CONFIG_FILE_KEY_TRACKERTIMEOUT="fastdfs.trackerTimeout";
    /** 从池中借出的对象的最大数目 */
    public static final String CONFIG_FILE_KEY_POOL_MAX_TOTAL="fastdfs.pool.maxTotal";
    /**最大等待时间  */
    public static final String CONFIG_FILE_KEY_MAXWAITMILLIS="fastdfs.pool.maxWaitMillis";
    
    /** 休眠时间超过了180秒的对象为过期 */
    public static final String CONFIG_FILE_KEY_MINEVICTABLEIDLETIMEMILLIS="fastdfs.pool.minEvictableIdleTimeMillis";
    
    /** 每60秒进行一次后台对象清理的行动  */
    public static final String CONFIG_FILE_KEY_TIMEBETWEENEVICTIONRUNSMILLIS="fastdfs.pool.timeBetweenEvictionRunsMillis";
    /** fdht 类型配置 **/
    public static final String CONFIG_FILE_KEY_FDHT_TYPE_KEY="fastdfs.fdht.type";
}
