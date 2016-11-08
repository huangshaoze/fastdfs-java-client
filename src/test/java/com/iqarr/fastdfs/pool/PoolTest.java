package com.iqarr.fastdfs.pool;



import org.junit.Test;




public class PoolTest {
    
    /* 连接池
    */
    
    @Test
    public void test() {
       
    }
    
   

    private FdfsConnectionPool createPool() {
        PooledConnectionFactory factory = new PooledConnectionFactory();
        factory.setConnectTimeout(100);
        factory.setSoTimeout(100);
        return new FdfsConnectionPool(new PooledConnectionFactory());
    }
    
}
