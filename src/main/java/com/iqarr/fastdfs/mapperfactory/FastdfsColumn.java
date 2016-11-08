package com.iqarr.fastdfs.mapperfactory;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 对象byte 映射
* @Title:
*	 	FdfsColumn.java
* @Package 
*		com.iqarr.fastdfs.mapperfactory
* @ClassName: 
*		FdfsColumn  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/23-13:44:50
* @version 
*		V1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FastdfsColumn {
    /** 映射顺序(从0开始) */
    int index() default 0;

    /** String最大长度 */
    int max() default 0;

    /** 动态属性 */
    DynamicFieldType dynamicField() default DynamicFieldType.NULL;

}
