package com.iqarr.fastdfs.dataobject;

import java.util.ArrayList;


/**
 * 
 * 基于ArrayList的循环链表类<br>
 * 第一次调用next()将返回第一个元素，调用previous()将返回最后一个元素
* @Title:
*	 	CircularList.java
* @Package 
*		com.iqarr.fastdfs.dataobject
* @ClassName: 
*		CircularList  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/22-11:56:47
* @version 
*		V1.0    
* @param <E>
 */
class CircularList<E> extends ArrayList<E> {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private int index = -1;

  
    /**
     * 
     * @Title: 
     *		reset
     * @Description: 
     *		重置，之后第一次调用next()将返回第一个元素，调用previous()将返回最后一个元素
     */
    public void reset() {
        synchronized (this) {
            index = -1;
        }
    }

    
    /**
     * 
     * @Title: 
     *		next
     * @Description: 
     *		下一个元素
     * @return
     */
    public E next() {
        check();

        synchronized (this) {
            index++;
            if (index >= this.size()) {
                index = 0;
            }
            return this.get(index);
        }

    }

    /**
     * 
     * @Title: 
     *		current
     * @Description: 
     *		当前元素
     * @return
     */
    public E current() {
        check();

        synchronized (this) {
            if (index < 0) {
                index = 0;
            }
            return this.get(index);
        }
    }

    
    /**
     * 
     * @Title: 
     *		previous
     * @Description: 
     *		上一个元素
     * @return
     */
    public E previous() {
        check();

        synchronized (this) {
            index--;
            if (index < 0) {
                index = this.size() - 1;
            }
            return this.get(index);
        }
    }

    /**
     * 
     * @Title: 
     *		check
     * @Description: 
     *		检查 防止使用空的链表
     */
    private void check() {
        if (this.size() == 0) {
            throw new IndexOutOfBoundsException("空的列表，无法获取元素");
        }
    }

}
