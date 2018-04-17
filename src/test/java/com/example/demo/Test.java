package com.example.demo;



import com.example.demo.bean.Admin;
import com.example.demo.bean.AdminConfig;
import com.example.demo.dao.AdminConfigDao;
import com.example.demo.dao.AdminDao;
import com.example.demo.util.mail.MailUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by xiaojie.Ma on 2018/3/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test1() {
        long num = System.currentTimeMillis();
        String numStr = String.valueOf(num);
        String num1 = numStr.substring(3,6)+numStr.substring(7,12);
        String num2 = num1.substring(0,1)+num1.substring(4,5)+num1.substring(1,4)+num1.substring(5,8);

    }

    @org.junit.Test
    public void test2() {
       String c = String.valueOf(System.currentTimeMillis()).substring(9,13);
        System.out.println(c);
    }


}
