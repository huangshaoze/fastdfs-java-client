package com.iqarr.fastdfs.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @Title:基本工具
 *             BaseUtils.java
 * @Package
 *          com.iqarr.fastdfs.common
 * @ClassName:
 *             BaseUtils
 * @since
 *        V1.0
 * @author
 *         zhangyong
 * @date
 *       2016/10/29-16:55:09
 * @version
 *          V1.0
 */
public class BaseUtils {
    /** 签名 长度 **/
    private final static int SIG_LENTH = 48;
    
    /**
     * 
     * @Title:
     *         frmatSignature
     * @Description:
     *               格式化签名
     * @param signature
     * @return
     */
    @SuppressWarnings("unused")
    private  static String frmatSignature(String signature) {
        if (signature == null || "".equals(signature)) {
            return "000000000000000000000000000000000000000000000000";
        }
        else {
            if (signature.length() == SIG_LENTH) {
                return signature;
            }
            else {
                StringBuffer sb = new StringBuffer();
                
                for (int i = 0; i < SIG_LENTH - signature.length(); i++) {
                    sb.append("0");
                }
                sb.append(signature);
                return sb.toString();
                
            }
        }
    }
    /**
     * 
     * @Title: 
     *		getFillSignature
     * @Description: 
     *		获取文件完整前面
     * @param fileSize long
     * @param signature 签名md5
     * @return
     */
    public static String getFillSignature(long fileSize, String signature) {
        
        if (signature == null || "".equals(signature)) {
            return "000000000000000000000000000000000000000000000000";
        } else {
            if (signature.length() == SIG_LENTH) {
                return signature;
            } else {
                String hexSize = Long.toHexString(fileSize);
                StringBuffer all = new StringBuffer();
                
                int size = hexSize.length() + signature.length();
                for (int i = 0; i < SIG_LENTH - size; i++) {
                    all.append("0");
                }
                all.append(hexSize);
                all.append(signature);
                return all.toString();
                
            }
        }
    }
    
    /**
     * 
     * @Title:
     *         stringMD5
     * @Description:
     *               获取文件md5
     * @param input
     * @return
     */
    public static String stringMD5(String input) {
        
        try {
            
            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
            
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            
            // 输入的字符串转换成字节数组
            
            byte[] inputByteArray = input.getBytes();
            
            // inputByteArray是输入字符串转换得到的字节数组
            
            messageDigest.update(inputByteArray);
            
            // 转换并返回结果，也是字节数组，包含16个元素
            
            byte[] resultByteArray = messageDigest.digest();
            
            // 字符数组转换成字符串返回
            
            return byteArrayToHex(resultByteArray);
            
        }
        catch (NoSuchAlgorithmException e) {
            
            return null;
            
        }
        
    }
    
    /**
     * 
     * @Title:
     *         byteArrayToHex
     * @Description:
     *               byte转Hex
     * @param byteArray
     * @return
     */
    public static String byteArrayToHex(byte[] byteArray) {
        
        // 首先初始化一个字符数组，用来存放每个16进制字符
        
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        
        char[] resultCharArray = new char[byteArray.length * 2];
        
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        
        int index = 0;
        
        for (byte b : byteArray) {
            
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            
            resultCharArray[index++] = hexDigits[b & 0xf];
            
        }
        
        // 字符数组组合成字符串返回
        
        return new String(resultCharArray);
        
    }
    
    /**
     * 
     * @Title:
     *         fileMD5
     * @Description:
     *               获取文件的md5
     * @param inputFile
     * @return
     * @throws IOException
     */
    public static String fileMD5(InputStream inputStream) throws IOException {
        
        // 缓冲区大小（这个可以抽出一个参数）
        
        int bufferSize = 256 * 1024;
        
       
        
        DigestInputStream digestInputStream = null;
        
        try {
            
            // 拿到一个MD5转换器（同样，这里可以换成SHA1）
            
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            
            // 使用DigestInputStream
            
           // fileInputStream = new FileInputStream(inputFile);
            
            digestInputStream = new DigestInputStream(inputStream, messageDigest);
            
            // read的过程中进行MD5处理，直到读完文件
            
            byte[] buffer = new byte[bufferSize];
            
            while (digestInputStream.read(buffer) > 0)
                ;
            
            // 获取最终的MessageDigest
            
            messageDigest = digestInputStream.getMessageDigest();
            
            // 拿到结果，也是字节数组，包含16个元素
            
            byte[] resultByteArray = messageDigest.digest();
            
            // 同样，把字节数组转换成字符串
            
            return byteArrayToHex(resultByteArray);
            
        }
        catch (NoSuchAlgorithmException e) {
            
            return null;
            
        }
        finally {
            
            try {
                
                digestInputStream.close();
                
            }
            catch (Exception e) {
                
            }
            
            try {
                
                inputStream.close();
                
            }
            catch (Exception e) {
                
            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {
      //  System.out.println(BaseUtils.frmatSignature("a"));
        //System.out.println(BaseUtils.frmatSignature("a").length());
        File file = new File("/home/user/image/1.png");
        InputStream in;
        in = new FileInputStream(file);
        System.out.println("md5:"+fileMD5(in));
    }
}
