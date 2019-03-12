package com.example.bean;

/**
 * @Author: zhang
 * @Date: 2019/2/14 19:58
 * @Description:
 */
class Shi {
    private String text;


    public Shi(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Shi{" +
                "text='" + text + '\'' +
                '}';
    }
}
