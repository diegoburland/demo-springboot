package com.demo.springboot.demo.configuration;

import com.demo.springboot.demo.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean myBean(){
        return new MyBeanImplement();
    }

    @Bean
    public MyOperation beanOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanWithDependency(MyOperation myOperation){
        return new MyBeanDependencyImplement(myOperation);
    }
}
