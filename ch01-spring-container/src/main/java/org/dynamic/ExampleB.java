package org.dynamic;

/**
 * @author yu
 * @date 2020/5/15
 */
public class ExampleB {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExampleB{" +
                "name='" + name + '\'' +
                '}';
    }

    public ExampleB() {
        System.out.println("ExampleB的默认构造函数");
    }
}
