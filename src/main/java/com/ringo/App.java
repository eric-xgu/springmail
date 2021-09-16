package com.ringo;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws  Exception
    {   //1、创建session 解析properties
        //2、通过session对象得到transport对象
        //3、使用用户名与密码连接邮件服务器
        //4、设置message对象
        //5、发送邮件

        //定义邮件服务器配置
        Properties properties=new Properties();
        //主机名、端口、是否验证
        properties.setProperty("mail.smtp.host","smtp.163.com");
        properties.setProperty("mail.smtp.port","25");
        properties.setProperty("mail.smtp.auth","true");

        Session session=Session.getInstance(properties);
        //开启debug，查看发送的流程与状态
        session.setDebug(true);

        Transport transport=session.getTransport();
        transport.connect("smtp.163.com","13896752412","GMPJNZNUHNOWUEOQ");

        //设置邮件对象
        Message message=createSimpleMail(session);
        transport.sendMessage(message,message.getAllRecipients());
        //关闭对象
        transport.close();

    }

    private static Message createSimpleMail(Session session)throws Exception {
        //创建普通文本邮件
        MimeMessage mimeMessage=new MimeMessage(session);
        //设置发送人,发送人与（transport）连接者一致
        mimeMessage.setFrom("13896752412@163.com");
        //设置邮件的接收者 TO发送、CC抄送、BCC密送
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress("13896752412@163.com"));
        //设置邮件主题
        mimeMessage.setSubject("工业4.0升级要求");
        //设置发送日期
        mimeMessage.setSentDate(new Date());
        //设置邮件的文本内容
        mimeMessage.setText("信息部：国产工业研发力度，产权自主可控，引领环球IT");
        return mimeMessage;
    }
}
