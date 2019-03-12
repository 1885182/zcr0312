package com.example.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 作者 zhang
 * 时间
 * 功能 请求数据
 */
public class RequestUtil {
    public static String getData(String textUrl){

        try {
            //获取到一个网络接口的对象---把接口地址转化成URL对象
            URL url = new URL(textUrl);
            //通过HttpURLConnection来进行网络请求
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //通过这个对象进行网络设置
            connection.setRequestMethod("GET");
            //获取状态码
            int i = connection.getResponseCode();
            //判断状态码
            if (i == HttpURLConnection.HTTP_OK){
                //获取到请求的数据
                InputStream inputStream = connection.getInputStream();
                //流传字符串
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String str = "";
                while ((str = reader.readLine())!=null){
                    builder.append(str);
                }
                return builder.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
