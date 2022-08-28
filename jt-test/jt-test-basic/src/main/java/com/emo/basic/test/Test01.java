package com.emo.basic.test;

import java.util.LinkedHashSet;

public abstract class Test01 {


    public static void mystery (int x)
    {
        System.out.print(x % 10);

        if ((x / 10) != 0)
        {
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
            case 3:
                result = result + i * 3;
                return result;
            case 4:
                result = result + i * 4;
                break;
            default:
                result = result + i;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
//        mystery(1234);
        System.out.println(getValue(2));

        Thread t = null;


        LinkedHashSet set = null;
    }


//    default String s;
    public final static native int w();
//    abstract double d;
//    abstract final double hyperbolicCosine();
}
