package com.iqarr.fastdfs.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
* @Title:
*	 	BaseUtilsTest.java
* @Package 
*		com.iqarr.fastdfs.common
* @ClassName: 
*		BaseUtilsTest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/11/30-14:29:23
* @version 
*		V1.0      
*/
public class BaseUtilsTest {
    
    /**
     * Test method for {@link com.iqarr.fastdfs.common.BaseUtils#getFillSignature(long, java.lang.String)}.
     */
    @Test
    public void testGetFillSignature() {
        System.out.println(BaseUtils.getFillSignature(627294, "cd2d400661313342c2f8ceca08e9f8fa"));
    }
    
}
