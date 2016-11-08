package com.iqarr.fastdfs.mapperfactory;

import static org.junit.Assert.*;
import java.nio.charset.Charset;


import org.junit.Test;

import com.iqarr.fastdfs.dataobject.FileInfo;

public class FdfsParamMapperFactoryTest {
    
    @Test
    public void testGetObjectMap() {
        FileInfo fInfo=new FileInfo();
        byte[] byte1 = FdfsParamMapperFactory.toByte(fInfo,Charset.defaultCharset());
       // System.out.printl(byte1.toString());
       System.out.println(" "+byte1.toString());
    }
    
}
