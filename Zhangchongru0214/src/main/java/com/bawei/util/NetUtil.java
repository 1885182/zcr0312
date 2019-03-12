package com.bawei.util;

import android.content.Context;

/**
 * 作者 zhang
 * 时间
 * 功能 判断网络
 */
public class NetUtil {
    public boolean isNetCode(Context context){
         context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return false;
    }
}
