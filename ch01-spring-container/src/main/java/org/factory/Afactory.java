package org.factory;

/**
 * @author yu
 * @date 2020/5/15
 */
public class Afactory {
    private static ExampleA exampleA = new ExampleA();

    public static ExampleA createA(){
        return exampleA;
    }
    public ExampleA createB(){
        return new ExampleA();
    }
}
