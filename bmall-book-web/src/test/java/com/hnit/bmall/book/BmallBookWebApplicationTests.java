package com.hnit.bmall.book;


import com.alibaba.dubbo.config.annotation.Reference;
import com.hnit.bmall.service.BookInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class BmallBookWebApplicationTests {

    @Reference
    BookInfoService bookInfoService;

    @Test
    public void contextLoads()  {

    }

}
