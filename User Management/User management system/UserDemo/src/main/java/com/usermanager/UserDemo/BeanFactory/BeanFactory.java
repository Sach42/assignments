package com.usermanager.UserDemo.BeanFactory;

import com.usermanager.UserDemo.Model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class BeanFactory {
    @Bean
    public Map<Integer, User> getUserMap()
    {
        return new HashMap<>();
    }
}
