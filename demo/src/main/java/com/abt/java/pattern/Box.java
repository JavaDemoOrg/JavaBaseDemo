package com.abt.java.pattern;

/**
 * Created by huangweiqi on 14/04/2018.
 */
public class Box<T> {

    private T data; //成员变量

    //第一种方式：无参构造传递数据
    public Box() {

    }

    public T setData(T data){
        this.data = data;
        return this.data;
    }

    //第二种方式：有参构造传递数据
    public Box(T data) {//有参构造函数
        this.data = data;//执行new操作的时候，初始化成员变量,将外部变量传给成员变量
    }

    public T getData() {

        return data;//直接返回数据
    }
}
