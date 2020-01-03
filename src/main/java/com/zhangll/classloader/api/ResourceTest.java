package com.zhangll.classloader.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * 本内容是为了了解类加载器以及获取
 */
public class ResourceTest {
    public static void main(String[] args) throws IOException {
        // 1. 获取全路径
        URL resource = Thread.currentThread().getContextClassLoader().getResource("livy-client.conf");
        // 当在当前资源目录中有该文件的时候,就会返回当前文件的全路径
        // 比如: file:/E:/github/nettytest/target/classes/livy-client.conf
        System.out.println(resource);
        // 运行这段的时候要确保，当前项目中的环境变量的类加载器加载
        URL resource2 = Thread.currentThread().getContextClassLoader().getResource("other.conf");
        // 当当前资源目录中没有文件，旧会返回null
        // null
        System.out.println(resource2);
        // 2. 获取URL的一个输入流，用来读取数据
        InputStreamReader readerfile = new InputStreamReader(resource.openStream(), UTF_8);

        // 3. 创建一个Properties，用来读取文件中的数据，格式为 abc=123，会自动注入
        Properties properties = new Properties();
        properties.load(readerfile);
        System.out.println("abc:" + properties.get("abc"));
        System.out.println("cd:" + properties.get("cd"));
        System.out.println("e:" + properties.get("e"));
        System.out.println("ef:" + properties.get("ef"));
        // 关闭流

        readerfile.close();
        System.out.println("===============================");
        // 直接返回一个流，也可以
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("spark-defaults.conf");
        properties.load(resourceAsStream);
        System.out.println("abc:" + properties.get("abc"));
        System.out.println("spark.jars："+ properties.getProperty("spark.jars"));
    }
 }
