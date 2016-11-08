package com.iqarr.fastdfs.proto.storage.internal;

import java.nio.charset.Charset;

import com.iqarr.fastdfs.constants.CmdConstants;
import com.iqarr.fastdfs.constants.FastdfsSystemConfig;
import com.iqarr.fastdfs.constants.OtherConstants;
import com.iqarr.fastdfs.mapperfactory.DynamicFieldType;
import com.iqarr.fastdfs.mapperfactory.FastdfsColumn;
import com.iqarr.fastdfs.mapperfactory.FdfsParamMapperFactory;
import com.iqarr.fastdfs.proto.FdfsRequest;
import com.iqarr.fastdfs.proto.ProtoHead;


/**
 * 
* @Title:  上传秒传文件md5 &hash
*	 	StorageUploadFileSigRequest.java
* @Package 
*		com.iqarr.fastdfs.proto.storage.internal
* @ClassName: 
*		StorageUploadFileSigRequest  
* @since 
*	  V1.0
* @author 
*		zhangyong   
* @date 
*		2016/10/29-10:18:22
* @version 
*		V1.0
 */
public class StorageUploadFileSigRequest extends FdfsRequest {
    
    
   
    
    
    /** 主文件名长度 */
    @FastdfsColumn(index = 0)
    private long masterFilenameLen=0;
    
    /** 原长度 */
    @FastdfsColumn(index = 1)
    private long sourceFilenameLen;
    
    /** 签名长度 */
    @FastdfsColumn(index = 2)
    private long sourceSignatureLen=48;
    
    /** 组名 */
    @FastdfsColumn(index = 3,max = OtherConstants.FDFS_GROUP_NAME_MAX_LEN)
    private String groupnName;
    
    /** 文件前缀名称　  */
    @FastdfsColumn(index = 4,max = OtherConstants.FDFS_FILE_PREFIX_MAX_LEN)
    private String filenamePrefix;
    
    /** 文件扩展名 **/
    @FastdfsColumn(index = 5,max = OtherConstants.FDFS_FILE_EXT_NAME_MAX_LEN)
    private String nameExt;
    /**文件名 **/
    @FastdfsColumn(index = 6)
    private String master_filename;
    
    /**主文件件名称   saveFile name 在使用上传的文件id **/
    @FastdfsColumn(index = 7,dynamicField=DynamicFieldType.allRestByte)
    private String sourceFilename;
    
    /** 文件签名**/
    @FastdfsColumn(index = 8,max=48)
    private String signature;
    
    /**文件大小 **/
    @FastdfsColumn(index = 9)
    private long fileSizes;
    
    /** 类型 0:官方  1:jfdht  **/
    @FastdfsColumn(index = 10)
    private long fdhtType=FastdfsSystemConfig.FDFS_TYPE;
    
    
   /**
    * 
   * <p>Title: 构造通过md5&hash 秒传</p>  
   * <p>Description:秒传 </p>  
   * @param fileSize    文件大小
   * @param signature　　　签名
   * @param prefixName　　前缀名称　 
   * @param fileExtName 后缀
    */
    public StorageUploadFileSigRequest( String groupName, long fileSize, String signature,
            String prefixName, String fileExtName) {
        super();
        this.groupnName=groupName;
        this.signature=signature;
      //  this.sourceSignatureLen=signature.length();
        this.filenamePrefix=prefixName;
        this.nameExt=fileExtName;
        long pack_len= FdfsParamMapperFactory.toByte(this,Charset.forName(FastdfsSystemConfig.FASTDFS_CHARSET)).length;
        head = new ProtoHead(pack_len,CmdConstants.STORAGE_PROTO_CMD_UPLOAD_FILE_BY_SIG,(byte)0);

    }
    /**
     * 
    * <p>Title:秒传从文件 </p>  
    * <p>Description: </p>  
    * @param groupName
    * @param fileSize
    * @param signature 签名
    * @param sourceFilename  主文件id
    * @param prefixName 前缀名称
    * @param fileExtName  后缀
     */
    public StorageUploadFileSigRequest( String groupName, long fileSize, String signature,
                   String sourceFilename,  String prefixName, String fileExtName) {
        
        this.sourceFilename=sourceFilename;
        this.sourceFilenameLen=sourceFilename.length();
        this.groupnName=groupName;
        this.signature=signature;
        this.filenamePrefix=prefixName;
        this.nameExt=fileExtName;
        long pack_len= FdfsParamMapperFactory.toByte(this,Charset.forName(FastdfsSystemConfig.FASTDFS_CHARSET)).length;
        head = new ProtoHead(pack_len,CmdConstants.STORAGE_PROTO_CMD_UPLOAD_FILE_BY_SIG,(byte)0);
    }
   

    @Override
    public long getFileSize() {
        return fileSizes;
    }



    /**
     * 获取 byte[ 
     * @return masterFilenameLen
     */
    public long getMasterFilenameLen() {
        return masterFilenameLen;
    }



    /**
     * 设置 byte[
     * @param masterFilenameLen byte[
     */
    public void setMasterFilenameLen(long masterFilenameLen) {
        this.masterFilenameLen = masterFilenameLen;
    }



    /**
     * 获取 原长度 
     * @return sourceFilenameLen
     */
    public long getSourceFilenameLen() {
        return sourceFilenameLen;
    }



    /**
     * 设置 原长度
     * @param sourceFilenameLen 原长度
     */
    public void setSourceFilenameLen(long sourceFilenameLen) {
        this.sourceFilenameLen = sourceFilenameLen;
    }



    /**
     * 获取 签名长度 
     * @return sourceSignatureLen
     */
    public long getSourceSignatureLen() {
        return sourceSignatureLen;
    }



    /**
     * 设置 签名长度
     * @param sourceSignatureLen 签名长度
     */
    public void setSourceSignatureLen(long sourceSignatureLen) {
        this.sourceSignatureLen = sourceSignatureLen;
    }



    /**
     * 获取 组名 
     * @return groupnName
     */
    public String getGroupnName() {
        return groupnName;
    }



    /**
     * 设置 组名
     * @param groupnName 组名
     */
    public void setGroupnName(String groupnName) {
        this.groupnName = groupnName;
    }



    /**
     * 获取 文件后缀 
     * @return filenamePrefix
     */
    public String getFilenamePrefix() {
        return filenamePrefix;
    }



    /**
     * 设置 文件后缀
     * @param filenamePrefix 文件后缀
     */
    public void setFilenamePrefix(String filenamePrefix) {
        this.filenamePrefix = filenamePrefix;
    }



    /**
     * 获取 文件扩展名 
     * @return nameExt
     */
    public String getNameExt() {
        return nameExt;
    }



    /**
     * 设置 文件扩展名
     * @param nameExt 文件扩展名
     */
    public void setNameExt(String nameExt) {
        this.nameExt = nameExt;
    }



    /**
     * 获取 文件名 
     * @return master_filename
     */
    public String getMaster_filename() {
        return master_filename;
    }



    /**
     * 设置 文件名
     * @param master_filename 文件名
     */
    public void setMaster_filename(String master_filename) {
        this.master_filename = master_filename;
    }



    /**
     * 获取 主文件件名称   saveFile name 在使用上传的文件id 
     * @return sourceFilename
     */
    public String getSourceFilename() {
        return sourceFilename;
    }



    /**
     * 设置 主文件件名称   saveFile name 在使用上传的文件id
     * @param sourceFilename 主文件件名称   saveFile name 在使用上传的文件id
     */
    public void setSourceFilename(String sourceFilename) {
        this.sourceFilename = sourceFilename;
    }



    /**
     * 获取 文件签名 
     * @return signature
     */
    public String getSignature() {
        return signature;
    }



    /**
     * 设置 文件签名
     * @param signature 文件签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }



    /**
     * 获取 文件大小 
     * @return fileSizes
     */
    public long getFileSizes() {
        return fileSizes;
    }



    /**
     * 设置 文件大小
     * @param fileSizes 文件大小
     */
    public void setFileSizes(long fileSizes) {
        this.fileSizes = fileSizes;
    }



    /**
     * 获取 类型 0:官方  1:jfdht 
     * @return fdhtType
     */
    public long getFdhtType() {
        return fdhtType;
    }



    /**
     * 设置 类型 0:官方  1:jfdht
     * @param fdhtType 类型 0:官方  1:jfdht
     */
    public void setFdhtType(long fdhtType) {
        this.fdhtType = fdhtType;
    }

    
    
}
