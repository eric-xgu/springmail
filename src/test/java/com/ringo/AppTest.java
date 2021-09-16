package com.ringo;

import static org.junit.Assert.assertTrue;

import com.ringo.springmail.SimpleUserManager;
import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
public class AppTest extends Base
{
    @Resource
    private SimpleUserManager simpleUserManager;
    @Test
    public void test()throws Exception{
       // simpleUserManager.send_mail();
        simpleUserManager.send_html();
    }
}
