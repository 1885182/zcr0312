package com.example.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 作者 zhang
 * 时间 2/13 20:07
 * 功能 判断网络
 */
public class NetUtil {
    //判断网络
    public boolean isNetConnected(Context context){
        if (context != null){
            //获取网络连接的管理器
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            //获取网络连接状态
            NetworkInfo info = manager.getActiveNetworkInfo();
            //判断网络状态
            if (info != null){
                return info.isAvailable();
            }
        }
        return false;
    }
}
