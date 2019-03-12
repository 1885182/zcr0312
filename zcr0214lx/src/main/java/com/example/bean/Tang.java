package com.example.bean;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/2/14 19:57
 * @Description:
 */
public class Tang {
    private List<Shi> data;

    public Tang(List<Shi> data) {
        this.data = data;
    }

    public List<Shi> getData() {
        return data;
    }

    public void setData(List<Shi> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tang{" +
                "data=" + data +
                '}';
    }
}
