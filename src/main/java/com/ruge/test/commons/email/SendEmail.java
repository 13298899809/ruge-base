package com.ruge.test.commons.email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 爱丽丝、如歌  创建于 2018/6/16 14:24
 * 说明:  TODO
 */
public class SendEmail {
    @Test
    public void test1() {
        // Create the email message
        HtmlEmail email = new HtmlEmail();
        //指定要使用的邮件服务器
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        //使用163的邮件服务器需提供在163已注册的用户名、密码
        email.setAuthentication("1345528755@qq.com", "pxqrfhgvejefieda");
        email.setSSL(true);
        email.setCharset("UTF-8");
        email.setSubject("Test email with inline image");
        //设置收件人  // qq, 163...
        try {
            email.addTo("863655397@qq.com", "John Doe");
            email.setFrom("1345528755@qq.com", "爱丽丝、如歌");

            File file = new File("d:\\9C4JPR0QO0.txt");//要发送的附件
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(file.getPath());
            attachment.setName(file.getName());
            attachment.setDescription("附件描述");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);//附件的类型
            email.attach(attachment);


            //   email.setTextMsg("Your email client does not support HTML messages");
            /*email.setHtmlMsg("<html>\n" +
                    "<head>\n" +
                    "<head>\n" +
                    "<body>\n" +
                     "<h1>谁在悬崖沏一壶茶</h1>\n" +
                    "</body>\n" +
                    "</html>");*/
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        //设置发件人

        //设置主题


    }
}
