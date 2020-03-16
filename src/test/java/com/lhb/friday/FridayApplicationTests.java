package com.lhb.friday;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
class FridayApplicationTests {

    @Resource
    DataSource dataSource;


    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }

}
