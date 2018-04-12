package com.example.demo.util.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by xiaojie.Ma on 2018/3/21.
 */
public class MailUtil {

    private static final String HOST = "smtp.163.com";
    private static final Integer PORT = 465;
    private static final String USERNAME = "15239131507@163.com";
    private static final String PASSWORD = "ma000000";
    private static final String EMAILFORM = "15239131507@163.com";
    private static JavaMailSenderImpl mailSender = createMailSender();
    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    private static JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);
        sender.setPort(PORT);
        sender.setUsername(USERNAME);
        sender.setPassword(PASSWORD);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
//
//        Properties props=new Properties();
//        // SSL加密
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            // 设置信任所有的主机
            sf.setTrustAllHosts(true);
            p.put("mail.smtp.ssl.enable", "true");
            p.put("mail.smtp.ssl.socketFactory", sf);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
//
        p.setProperty("mail.transport.protocol", "smtp");
//        props.setProperty("mail.smtp.host", "smtp.ym.163.com");
        p.setProperty("mail.smtp.auth", "true");//请求身份认证
//
//




        p.setProperty("mail.smtp.timeout", "25000");
        p.setProperty("mail.smtp.auth", "false");
        sender.setJavaMailProperties(p);
        return sender;
    }

    /**
     * 发送邮件
     *
     * @param to 接受人
     * @param subject 主题
     * @param html 发送内容
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     */
    public static void sendHtmlMail(String to, String subject, String html) throws MessagingException,UnsupportedEncodingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(EMAILFORM, "系统名称");
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);
        mailSender.send(mimeMessage);
    }

}
