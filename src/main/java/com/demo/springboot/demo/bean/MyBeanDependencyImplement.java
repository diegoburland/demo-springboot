package com.demo.springboot.demo.bean;

public class MyBeanDependencyImplement implements MyBeanWithDependency {

    private MyOperation myOperation;

    public MyBeanDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un bean con dependencia");
    }

}
