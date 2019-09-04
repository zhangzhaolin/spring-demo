package com.shiwa.spring.dev;

import com.shiwa.spring.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 模拟生产环境下需要使用的类
 *
 * @author zhang
 */
@Component("helloService")
@PropertySource(value = "classpath:/development/config.properties")
public class DevHelloServiceImpl implements HelloService {

    @Value("${name}")
    private String name;

    @Override
    public String sayHello() {
        return String.format("hello,I'm %s,this is a development environment!", name);
    }
}
