package com.example.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @Author: zhang
 * @Date: 2019/2/14 18:51
 * @Description:判断网络
 */
public class NetUtil {
    public boolean isNetConnected(Context context){
        if (context != null){
            //获取网络连接的管理器
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            //获取网络链接状态(注意添加权限)
            NetworkInfo info = manager.getActiveNetworkInfo();
            //判断网络状态
            if (info != null){
                return info.isAvailable();
            }
        }
        return false;
    }
}
