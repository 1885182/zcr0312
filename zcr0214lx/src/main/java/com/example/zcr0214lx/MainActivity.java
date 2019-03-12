package com.example.zcr0214lx;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.adapter.MyPagerAdapter;
import com.example.bean.Tang;
import com.example.util.HttpUtils;
import com.example.util.NetUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用AsyncTask进行异步任务处理
 * 异步请求数据---去解析展示
 * 异步请求图片---展示到控件
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ImageView imageView;
    private List<String> list;
    private String dataUrl = "https://www.apiopen.top/satinApi?type=1&page=1";
    private String picUrl = "http://f.expoon.com//sub//news//2016//01//21//158040_230x162_0.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        imageView = findViewById(R.id.img);
        //网络判断一般放进工具类里面
        NetUtil util = new NetUtil();
        boolean netConnected = util.isNetConnected(MainActivity.this);
        if (netConnected){
            //进行异步请求数据
            MyAsyncTask myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(dataUrl);
            //进行异步请求图片
            Glide.with(MainActivity.this).load(picUrl).into(imageView);
        }else {
            //没网
        }
    }
    //创建内部类---请求数据的
    public class MyAsyncTask extends AsyncTask<String,Void,String>{
        //主线程---更新
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Tang fromJson = gson.fromJson(s, Tang.class);
            list = new ArrayList<String>();
            list.add(fromJson.getData().toString());
            MyPagerAdapter adapter = new MyPagerAdapter(list,MainActivity.this);
            listView.setAdapter(adapter);
        }
        //子线程---耗时操作
        @Override
        protected String doInBackground(String... strings) {
            //请求网络数据集
            String data = HttpUtils.getNetData(strings[0]);
            return data;
        }
    }
    //创建内部类---请求图片
    public class PicAsyncTask extends AsyncTask<String,Void,Bitmap>{
        ImageView iv;

        public PicAsyncTask(ImageView iv) {
            this.iv = iv;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap pic = HttpUtils.getNetPic(strings[0]);
            return pic;
        }
    }
}
