package com.lanxin;

import com.lanxin.service.UserService;
import com.lanxin.util.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTest.class)
@ComponentScan(basePackages = "com.lanxin")
@MapperScan(basePackages = "com.lanxin.dao")
public class AppTest 
{
     @Autowired
     private UserService userService;

    @Test
    public void testUser()
    {
        Result users=userService.findAllUser();
    }

    @Test
    public void findByusername()
    {
        Result users=userService.getPassByUsername("cyh");
    }
}
