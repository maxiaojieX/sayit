package com.example.demo.util.mail;

import org.springframework.mail.MailSendException;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/22.
 */
public class CodeEmailUtil {

    public static Map<String,String> codes = new Hashtable<>();

    public static void sendMail(String to) throws MailSendException {
        String title = "【Say it】账户注册";
        String begin = "您的验证码是: ";
        String code = String.valueOf(System.currentTimeMillis()).substring(8,12);
        try {
            codes.put(to,code);
            MailUtil.sendHtmlMail(to,title,"您的验证码是:"+code+"。如果你没有进行相关操作，请忽略该邮件。");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
