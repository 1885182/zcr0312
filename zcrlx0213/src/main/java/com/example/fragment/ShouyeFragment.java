package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.util.NetUtil;
import com.example.util.RequestUtil;
import com.example.zcrlx0213.R;

/**
 * 作者 zhang
 * 时间 2/13 20:03
 * 功能 网络请求获取 解析展示
 * ******************
 * 注意:网络请求属于耗时操作,需要放在子线程中
 */
public class ShouyeFragment extends Fragment {
    private String textUrl = "https://api.apiopen.top/getTangPoetry?page=1&count=20";
    private String picYrl = "http://hiphotos.qianqian.com/ting/pic/item/838ba61ea8d3fd1fb4912e42354e251f95ca5f2a.jpg";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //注意:一般情况下网络判断都会放在工具类中
        NetUtil util = new NetUtil();
        boolean netConnected = util.isNetConnected(getActivity());
        if (netConnected){
            new Thread(){
                @Override
                public void run() {
                    String data = RequestUtil.getData(textUrl);
                    Log.d("aaa",""+data);

                }
            }.start();

        }else {
            Log.d("aaa","没网");
        }

    }
}
