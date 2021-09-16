package com.ringo.springmail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;


import java.io.File;

@Service
public class SimpleUserManager implements UserManager {
    @Resource
    private MailSender mailSender;
    @Resource
    private SimpleMailMessage templatemessage;
    @Override
    public void send_mail() {
        SimpleMailMessage msg=new SimpleMailMessage(this.templatemessage);
        msg.setTo("13896752412@163.com");
        msg.setText("ringo");
        try{
            mailSender.send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //多媒体文件
    public void send_html() throws  Exception{
        JavaMailSender sender= (JavaMailSender) mailSender;
        MimeMessage message= sender.createMimeMessage();
        message.setSubject("泸州");
        //创建带有附件的帮助类
        MimeMessageHelper helper=new MimeMessageHelper(message,true,"UTF-8");
        helper.setTo("13896752412@163.com");
        helper.setFrom("13896752412@163.com");
        //设置邮件内容
        helper.setText("........");
        //设置附件
        File file=new File("D:/01001_SEASON.txt");
        //添加附件
        helper.addAttachment(file.getName(),file);
        sender.send(message);
    }
}
