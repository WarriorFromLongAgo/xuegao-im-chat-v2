package com.xuegao.wechatservermonolith;

// import com.google.common.io.Resources;

import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

@SpringBootTest
class WechatServerMonolithApplicationTests {

    @Test
    void contextLoads() throws IOException {
        // ClassPathResource类的构造方法接收路径名称，自动去classpath路径下找文件
        ClassPathResource classPathResource = new ClassPathResource("test.txt");

        // 获得File对象，当然也可以获取输入流对象
        File file = classPathResource.getFile();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }

        String s = content.toString();
        System.out.println(s);
    }


    @Test
    void contextLoads2() throws IOException {
        URL resource = Resources.getResource("test.txt");
        System.out.println(resource);
    }
}
