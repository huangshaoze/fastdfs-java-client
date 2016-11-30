package com.iqarr.fastdfs;

import com.iqarr.fastdfs.common.BaseUtils;
import com.iqarr.fastdfs.dataobject.StorePath;
import com.iqarr.fastdfs.service.TrackerClient;
import com.iqarr.fastdfs.service.impl.DefaultGenerateStorageClient;
import com.iqarr.fastdfs.service.impl.DefaultTrackerClient;

/**
 * 
* @Title:测试秒传
*	 	TsetSig.java
* @Package 
*		com.iqarr.fastdfs
* @ClassName: 
*		TsetSig  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/29-11:14:39
* @version 
*		V1.0
 */
public class TestSig {
    
    public static void main(String[] args) {
        InItFastdfs.Init();
        TrackerClient dtc = new DefaultTrackerClient();
       // System.out.println("0000000000099246768639FA12E54362CA4DEEFE3AB5AEB8".length());
        DefaultGenerateStorageClient sgsc = new DefaultGenerateStorageClient(dtc);
        //上传主文件
        StorePath uploadFile = sgsc.uploadFileSig("group1", "0000000000099246768639FA12E54362CA4DEEFE3AB5AEB8", 200, "_AAAA",".png");
        if (uploadFile == null) {
            System.out.println("file not find");
        }
        else {
            System.out.println(uploadFile.toString());
        }
        
        //上传从文件
        uploadFile = sgsc.uploadSlaveFileSig("group1",BaseUtils.getFillSignature( 1000,"0000000000099246768639FA12E54362CA4DEEFE3AB5AEB8"),uploadFile.getPath(), 200, "_AAAA",".png");
        if (uploadFile == null) {
            System.out.println("file not find");
        }
        else {
            System.out.println(uploadFile.toString());
        }
    }
}
