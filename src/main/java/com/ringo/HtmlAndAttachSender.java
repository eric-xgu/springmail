package com.ringo;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class HtmlAndAttachSender {
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
        //发送邮件对象
        Transport transport=session.getTransport();
        transport.connect("smtp.163.com","13896752412","GMPJNZNUHNOWUEOQ");

        /*
        * html是多媒体对象，需要MimeMultiPart对象与MimeBodyPart对象
        * MimeMultiPart包含MimeBodyPart， MimeBodyPart来包含html
        * 消息对象
        * */
        Message message=createAttach(session);
        //发送邮件
        transport.sendMessage(message,message.getAllRecipients());
        //关闭对象
        transport.close();

    }

    private static Message createAttach(Session session) throws  Exception{
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

        //设置多媒体对象容器
        MimeMultipart mimeMultipart=new MimeMultipart();
        MimeBodyPart mimeBodyPart=new MimeBodyPart();
        StringBuffer sb=new StringBuffer();
        sb.append("<html><head></head><body><h1>信息部：国产工业研发力度，产权自主可控，引领环球IT</h1><body></html>");
        mimeBodyPart.setContent(sb.toString(),"text/html;charset=UTF-8");
        mimeMultipart.addBodyPart(mimeBodyPart);

        //附件对象
        MimeBodyPart mimeBodyPart1=new MimeBodyPart();
        DataHandler dataHandler=new DataHandler(new FileDataSource("D:/最终导入站号.csv"));
        //将附件放入多媒体对象
        mimeBodyPart1.setDataHandler(dataHandler);
        //设置附件名
        mimeBodyPart1.setFileName(dataHandler.getName());
        //添加附件
        mimeMultipart.addBodyPart(mimeBodyPart1);
        //设置附件类型
        mimeMultipart.setSubType("mixed");

        mimeMessage.setContent(mimeMultipart);
        return mimeMessage;
    }


}
