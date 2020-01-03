package com.zhangll.web;

import java.net.URI;
import java.net.URISyntaxException;

public class URIDemo {
    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http://192.168.10.63");
        System.out.println(uri.getPort());
    }
}
