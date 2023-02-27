package com.demo.springboot.demo.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanDependencyImplement implements MyBeanWithDependency {

    private MyOperation myOperation;
    private final Log LOGGER = LogFactory.getLog(MyBeanDependencyImplement.class);
    public MyBeanDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;



    }

}
