package com.example.demo.util;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/20.
 */
public class GetAccountNumberUtil {

    /**
     * 账号生成方法
     * @return
     */
    public static String getAccountNum(){
        long num = System.currentTimeMillis();
        String numStr = String.valueOf(num);
        String num1 = numStr.substring(3,6)+numStr.substring(7,12);
        String num2 = num1.substring(0,1)+num1.substring(4,5)+num1.substring(1,4)+num1.substring(5,8);
        return num2;
    }

}
