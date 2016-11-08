package com.iqarr.fastdfs.constants;

import java.util.List;

/**
 * 系统配置信息,静态变量  初始化时添加
* @Title:
*	 	FastdfsSystemConfig.java
* @Package 
*		com.iqarr.fastdfs.constants
* @ClassName: 
*		FastdfsSystemConfig  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/23-14:24:52
* @version 
*		V1.0
 */
public class FastdfsSystemConfig {
   
    /** 编码 */
    public static  String FASTDFS_CHARSET;
    /**tracker 服务器  */
    public static  List<String> FASTDFS_TRACKERLIST;
    /** 连接超时 */
    public static  int FASTDFS_CONNECTTIMEOUT;
    /** 连接tracker超时重试时间 */
    public static  int FASTDFS_TRACKERTIMEOUT;
    /** 从池中借出的对象的最大数目 */
    public static  int FASTDFS_POOL_MAX_TOTAL;
    /**最大等待时间  */
    public static  int FASTDFS_MAXWAITMILLIS;
    
    /** 休眠时间超过了n秒的对象为过期 */
    public static  int FASTDFS_MINEVICTABLEIDLETIMEMILLIS;
    
    /** 进行一次后台对象清理的行动  */
    public static  int FASTDFS_TIMEBETWEENEVICTIONRUNSMILLIS;
    
    /** 类型 0:官方  1:jfdht   外部配置**/
    public static long FDFS_TYPE=0;
}
