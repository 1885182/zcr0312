package com.bawei.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: zhang
 * @Date: 2019/2/15 8:50
 * @Description:请求数据
 */
public class HttpUtil {
    public static void dataConnection(String string){

        try {
            URL url = new URL(string);
            URLConnection urlConnection = url.openConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
