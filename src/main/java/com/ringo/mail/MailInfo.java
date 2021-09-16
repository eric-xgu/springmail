package com.ringo.mail;

import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;

public class MailInfo {
    private String smtp_host;
    private String port;
    private String user_name;
    private String passwd;
    private String sender_mail;
    private List<String> reciver_mail;
    private int send_cc; //0发送、1、抄送、2、密送
    private String subject; //主题
    private MimeMessage mimeMessage; //文本对象
    private MimeMultipart mimeMultipart; //多媒体对象
    private List<MimeBodyPart> mimeBodylist; //多媒体body对象 可以放置html,csv文件
}
