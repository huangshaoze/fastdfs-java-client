package com.iqarr.fastdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.Validate;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iqarr.fastdfs.constants.FastdfsSystemConfig;
import com.iqarr.fastdfs.constants.FastdfsSystemConstants;
import com.iqarr.fastdfs.pool.ConnectionManager;
import com.iqarr.fastdfs.pool.FdfsConnectionPool;
import com.iqarr.fastdfs.pool.PooledConnectionFactory;
import com.iqarr.fastdfs.pool.TrackerConnectionManager;

/**
 * 初始化系统
 * 
 * @Title:
 *         InItFastdfs.java
 * @Package
 *          com.iqarr.fastdfs
 * @ClassName:
 *             InItFastdfs
 * @since
 *        V1.0
 * @author
 *         zhangyong
 * @date
 *       2016/10/22-10:34:11
 * @version
 *          V1.0
 */
public class InItFastdfs {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(InItFastdfs.class);
    
    /**
     * 
     * @Title:
     *         Init
     * @Description:
     *               外部系统必须初始化该方法
     */
    public static void Init() {
        
        try {
            
            // 读取config
            URL resource = InItFastdfs.class.getClassLoader().getResource(FastdfsSystemConstants.CONFIG_FILE_NAME);
            InputStream in = new FileInputStream(new File(resource.getPath()));
            Properties properties = new Properties();
            properties.load(in);
            Object charset = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_CHARSET);
            Object connecttimeout = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_CONNECTTIMEOUT);
            Object maxwaitmillis = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_MAXWAITMILLIS);
            Object minEvictableIdleTimeMillis = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_MINEVICTABLEIDLETIMEMILLIS);
            Object poolMaxTotal = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_POOL_MAX_TOTAL);
            Object timeBetweenEvictionRunsMillis = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_TIMEBETWEENEVICTIONRUNSMILLIS);
            Object fdhtType = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_FDHT_TYPE_KEY);
            List<String> trackerList=new ArrayList<>();
            for(int i=0;i<FastdfsSystemConstants.MAX_TRACERT_NUMBER;i++){
                Object tracert = properties.get(FastdfsSystemConstants.CONFIG_FILE_KEY_TRACKERLIST+i);
                if(null==tracert){
                    break;
                }else {
                    trackerList.add(tracert+"");
                }
             }
            Validate.notNull(charset);
            FastdfsSystemConfig.FASTDFS_CHARSET=charset+"";
            FastdfsSystemConfig.FASTDFS_TRACKERLIST=trackerList;
            FastdfsSystemConfig.FASTDFS_CONNECTTIMEOUT=Integer.parseInt(connecttimeout+"") ;
            FastdfsSystemConfig.FASTDFS_MAXWAITMILLIS=Integer.parseInt(maxwaitmillis+"") ;
            FastdfsSystemConfig.FASTDFS_MINEVICTABLEIDLETIMEMILLIS=Integer.parseInt(minEvictableIdleTimeMillis+"") ;
            FastdfsSystemConfig.FASTDFS_POOL_MAX_TOTAL=Integer.parseInt(poolMaxTotal+"");
            FastdfsSystemConfig.FASTDFS_TIMEBETWEENEVICTIONRUNSMILLIS=Integer.parseInt(timeBetweenEvictionRunsMillis+"");
            FastdfsSystemConfig.FDFS_TYPE=Integer.parseInt(fdhtType+"");
                
            //init base config
            TrackerConnectionManager.trackerList=FastdfsSystemConfig.FASTDFS_TRACKERLIST;
            //init connect pool
            GenericKeyedObjectPoolConfig config=new GenericKeyedObjectPoolConfig();
            config.setMaxTotal(FastdfsSystemConfig.FASTDFS_POOL_MAX_TOTAL); // 整个对象池数量
            int maxKey=8;
            if(FastdfsSystemConfig.FASTDFS_POOL_MAX_TOTAL/trackerList.size()>0){
                maxKey=FastdfsSystemConfig.FASTDFS_POOL_MAX_TOTAL/trackerList.size();
               }
            config.setMaxTotalPerKey(maxKey);  //每个key总数数量大小
            config.setTestWhileIdle(true);
            config.setBlockWhenExhausted(true);
            config.setMaxWaitMillis(FastdfsSystemConfig.FASTDFS_MAXWAITMILLIS);
            config.setMinEvictableIdleTimeMillis(FastdfsSystemConfig.FASTDFS_MINEVICTABLEIDLETIMEMILLIS); // 视休眠时间超过了180秒的对象为过期
            config.setTimeBetweenEvictionRunsMillis(FastdfsSystemConfig.FASTDFS_TIMEBETWEENEVICTIONRUNSMILLIS); // 每过60秒进行一次后台对象清理的行动
            config.setNumTestsPerEvictionRun(-1);
            //KeyedPooledObjectFactory<InetSocketAddress, Connection> factory=new  KeyedPooledObjectFactory<InetSocketAddress, Connection>();
            ConnectionManager.pool= new FdfsConnectionPool(new  PooledConnectionFactory(),config);
        }
            
        catch (FileNotFoundException e) {
            LOGGER.error("初始化失败:"+e.getMessage());
        }
        catch (IOException e) {
            LOGGER.error("初始化失败:"+e.getMessage());
        }
        
    }
}
