package com.shiwa.spring.product;

import com.shiwa.spring.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 模拟开发环境下使用的类
 *
 * @author zhang
 */
@Component("helloService")
@PropertySource(value = "classpath:/product/config.properties")
public class ProductHelloServiceImpl implements HelloService {

    @Value("${name}")
    private String name;

    @Override
    public String sayHello() {
        return String.format("hello,I'm %s,this is a produce environment!", name);
    }
}
