package com.bawei.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.HttpURLConnection;

/**
 * @Author: zhang
 * @Date: 2019/2/15 8:44
 * @Description:判断网络是否连接
 */
public class NetUtil {
    public boolean isNetConnection(Context context){
        if (context != null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null){

            }
        }
        return false;
    }
}
