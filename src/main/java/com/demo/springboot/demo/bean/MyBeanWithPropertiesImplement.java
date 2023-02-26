package com.demo.springboot.demo.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    private String name;
    private String apellido;
    private String random;

    public MyBeanWithPropertiesImplement(String name, String apellido, String random) {
        this.name = name;
        this.apellido = apellido;
        this.random = random;
    }

    @Override
    public String function() {
        return name + "-" + apellido + "-" + random;
    }

}
