package org.relation;

/**
 * @author yu
 * @date 2020/5/17
 */
public class ChildOne {
    private String childOne;
    private String name;
    private String addr;

    @Override
    public String toString() {
        return "Child{" +
                "childOne='" + childOne + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getChildOne() {
        return childOne;
    }

    public void setChildOne(String childOne) {
        this.childOne = childOne;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
