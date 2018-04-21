package com.abt.java.pattern;

public class Pattern {

    public static void main(String[] args) {
        //第一种方式：无参构造传递数据
        Box<String> Str = new Box<String>();
        Str.setData("sun");
        System.out.println("First Way :" + Str.getData());

        Box<Integer> Int = new Box<Integer>();
        Int.setData(123455677);
        System.out.println("First Way :" + Int.getData());

        Box<Number> Num = new Box<Number>();
        Num.setData(777777777);
        System.out.println("First Way :" + Num.getData()+"\n");

        //第二种方式：有参构造传递数据
        Box<String> name = new Box<String>("corn");//new的动作-->执行：this.data = data;
        Box<Integer> age = new Box<Integer>(712);
        Box<Number> number = new Box<Number>(314);

        PrintData(name);
        PrintData(age);
        PrintData(number);
    }

    public static void PrintData(Box<?> data) {
        System.out.println("Second Way :" + data.getData());
    }

}
