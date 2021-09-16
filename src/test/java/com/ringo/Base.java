package com.ringo;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//将测试运行在spring环境中
@RunWith(SpringJUnit4ClassRunner.class)
//设置需要加载的文件
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class Base {
}