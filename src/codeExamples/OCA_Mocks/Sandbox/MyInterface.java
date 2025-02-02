package codeExamples.OCA_Mocks.Sandbox;

interface BaseInterface1 {
    default void getName() {
        System.out.println("Base1");
    }
}

interface BaseInterface2 {
    default void getName() {
        System.out.println("Base2");
    }
}

public class MyInterface implements BaseInterface1,BaseInterface2{
    public void getName() {
        BaseInterface1.super.getName();
    }
}
