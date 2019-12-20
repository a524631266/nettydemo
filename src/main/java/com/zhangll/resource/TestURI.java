package com.zhangll.resource;

import java.net.URI;
import java.net.URISyntaxException;

public class TestURI {
    public static void main(String[] args) {
        try {
            URI uri = new URI("http://zhangll@developers.weixin.qq.com/miniprogram/dev/api/open.html#wxgetuserinfoobject?name=asdfasd");
//            URI uri = URI.create("zhangll:192.168.10.63:8000");
            System.out.println(uri.getUserInfo());
            URI uri2 = new URI("http",uri.getUserInfo(),uri.getHost(),uri.getPort(),uri.getPath(),uri.getQuery(),uri.getFragment());
            System.out.println(uri2.getUserInfo());
            System.out.println(uri2.getScheme());
            System.out.println(uri2.getHost());
            System.out.println(uri2.getPort());
            System.out.println(uri2.getPath());
            System.out.println(uri2.getQuery());
            System.out.println(uri2.getFragment());
            System.out.println(uri2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
