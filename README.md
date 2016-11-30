## <center>fastdfs-java-client
`fastdfs-java-client` 是fastdfs的java端客户端，重构整个java客户端，并在原有的基础上添加秒传的功能(秒传功能需要fdhtd支持)

# 简介

`fastdfs-java-client`重构整个java客户端,增加代码可读性，并添加` commons-pool2`连接池

* ` commons-pool2`连接池 可以重用连接
* 支持秒传　目前支持md5
	* 可以通过js传入文件md5值，如果存在可以直接得到文件上传路径


*** 

# Quick Start

## 引入maven依赖

```xml
<!-- 引入fastdfs-java-client模块 -->
<dependency>
    <groupId>com.iqarr.fastdfs</groupId>
	<artifactId>fastdfs-java-client</artifactId>
	<version>0.0.1</version>
</dependency>
```
## 配置上传信息
`fastdfs-java-client`的配置文件`src/main/resource/fastdfs.properties`：
```properties
#默认字符集
fastdfs.defult.charset.name=UTF-8
#TrackerList参数,支持多个必须从0开始中间不能中段
fastdfs.trackerList.0=192.168.2.222:22122
# sockert连接超时时间
fastdfs.connectTimeout=601
# 连接tracker超时时间
fastdfs.trackerTimeout=1501
#连接池配置
#从池中借出的对象的最大数目,注意该值应该是总共tracker数量*每个tracker需要的数量(该值请参考storage中socker数量)
fastdfs.pool.maxTotal=250
#最大等待时间
fastdfs.pool.maxWaitMillis=1000
## 休眠时间超过了180秒的对象为过期
fastdfs.pool.minEvictableIdleTimeMillis=180000
#  每60秒进行一次后台对象清理的行动
fastdfs.pool.timeBetweenEvictionRunsMillis=60000
#　(秒传必须配置)fdht　使用类型　0:官方默认　１:java fdht
fastdfs.fdht.type=0
```

## 上传文件
```java
InItFastdfs.Init();
TrackerClient tc = new DefaultTrackerClient();
DefaultGenerateStorageClient sgsc = new DefaultGenerateStorageClient(tc);
StorePath uploadFile = sgsc.uploadFile(null, new FileInputStream(new File("/home/user/image.png")), file.length(), "png");
System.out.println(uploadFile.toString());
```

## 秒传
```java
		InItFastdfs.Init();
        TrackerClient dtc = new DefaultTrackerClient();
       // System.out.println("0000000000099246768639FA12E54362CA4DEEFE3AB5AEB8".length());
        GenerateStorageClient sgsc = new DefaultGenerateStorageClient(dtc);
        //上传主文件
        StorePath uploadFile = sgsc.uploadFileSig("group1", "0000000000099246768639FA12E54362CA4DEEFE3AB5AEB8", 200, "_AAAA",".png");
        if (uploadFile == null) {
            System.out.println("file not find");
        }
        else {
            System.out.println(uploadFile.toString());
        }
        //上传从文件
        uploadFile = sgsc.uploadSlaveFileSig("group1",BaseUtils.getFillSignature(122, "0000000000099246768639FA12E54362CA4DEEFE3AB5AEB8"),uploadFile.getPath(), 200, "_AAA11A",".png");
        if (uploadFile == null) {
            System.out.println("file not find");
        }
        else {
            System.out.println(uploadFile.toString());
        }
```
