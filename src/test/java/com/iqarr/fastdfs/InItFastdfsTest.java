package com.iqarr.fastdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.InetSocketAddress;

import org.junit.Test;

import com.iqarr.fastdfs.dataobject.StorePath;
import com.iqarr.fastdfs.pool.TrackerConnectionManager;
import com.iqarr.fastdfs.service.TrackerClient;
import com.iqarr.fastdfs.service.impl.DefaultGenerateStorageClient;
import com.iqarr.fastdfs.service.impl.DefaultTrackerClient;

public class InItFastdfsTest {
    
    @Test
    public void test() throws FileNotFoundException {
       InItFastdfs.Init();
        
       TrackerConnectionManager tcm=new TrackerConnectionManager();
       tcm.dumpPoolInfo(new InetSocketAddress("192.168.2.222", 22122));
       
    }
    
    public static void main(String[] args) {
        InItFastdfs.Init();
        TrackerClient dtc = new DefaultTrackerClient();
        //TrackerConnectionManager tcm=new TrackerConnectionManager();
         for(int i=0;i<220;i++){
             Thread t=new Thread(new RunUpload(dtc));
             t.start();
           //  System.out.println("start i:"+i);
         }
    }
    
}

class RunUpload implements Runnable {
    TrackerClient dtc ;
    //DefaultGenerateStorageClient sgsc;
    
    /**  
    * <p>Title: </p>  
    * <p>Description: </p>  
    * @param dtc  
    */
    public RunUpload(TrackerClient dtc) {
        super();
        this.dtc = dtc;
       
    }

    @Override
    public void run() {
       
        
        DefaultGenerateStorageClient sgsc = new DefaultGenerateStorageClient(dtc);
        
        File file = new File("/home/user/image.png");
        InputStream in;
        for (int i = 0; i < 10000; i++) {
           
            try {
                in = new FileInputStream(file);
                StorePath uploadFile = sgsc.uploadFile(null, in, file.length(), "jpg");
               // System.out.println(uploadFile.toString());
                in.close();
            }
            catch (Exception e) {
               // e.printStackTrace();
                //System.out.println("RunUpload Exception:"+e.getMessage());
            }
           
        }
        System.out.println("RunUpload end");
        
    }
    
}