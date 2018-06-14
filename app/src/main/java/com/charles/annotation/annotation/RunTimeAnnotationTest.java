package com.charles.annotation.annotation;

/**
 * Created by 17111980 on 2018/6/13.
 */

public class RunTimeAnnotationTest {

    @RunTimeAnnotation(textMsg = "我是msg")
    public String getMsg() {
        return "";
    }

    @RunTimeAnnotation(ipMsg = "www.baidu.com")
    public String getIpMsg() {
        return "";
    }

}
