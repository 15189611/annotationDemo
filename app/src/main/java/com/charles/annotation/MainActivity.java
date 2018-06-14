package com.charles.annotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.charles.annotaion.BindView;
import com.charles.annotation.annotation.RunTimeAnnotation;
import com.charles.annotation.annotation.RunTimeAnnotationTest;

import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {

    @BindView(value = R.id.tv_text_msg)
    TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.运行时注解
        testRunTimeAnnotation(RunTimeAnnotationTest.class, RunTimeAnnotation.class);

        //2.编译时注解

    }

    private void testRunTimeAnnotation(Class<?> clazz, Class<RunTimeAnnotation> annotationType) {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            RunTimeAnnotation annotation = method.getAnnotation(annotationType);
            if (annotation != null) {
                if (!TextUtils.isEmpty(annotation.ipMsg())) {
                    String ipMsg = annotation.ipMsg();
                    Log.e("Charles2", "ipMsg==" + ipMsg);
                }
                if (!TextUtils.isEmpty(annotation.textMsg())) {
                    String msg = annotation.textMsg();
                    Log.e("Charles2", "msg==" + msg);
                }
            }
        }
    }


}
