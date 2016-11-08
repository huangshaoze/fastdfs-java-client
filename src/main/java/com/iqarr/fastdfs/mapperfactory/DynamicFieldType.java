package com.iqarr.fastdfs.mapperfactory;


/**
 * 动态属性类型
 * <pre>
 * 可以为空的属性-不发送该报文
 * 剩余的所有byte-将该字段全部写入到最后的byte当中
 * </pre>
* @Title:
*	 	DynamicFieldType.java
* @Package 
*		com.iqarr.fastdfs.mapperfactory
* @ClassName: 
*		DynamicFieldType  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/23-13:44:05
* @version 
*		V1.0
 */
public enum DynamicFieldType {
    /** 非动态属性 */
    NULL,
    /** 剩余的所有Byte */
    allRestByte,
    /** 可空的属性 */
    nullable,
    /** 文件元数据Set */
    matedata,
    /** 该字段的全部长度**/
    ALL_FIELD_LENTH
    
}
