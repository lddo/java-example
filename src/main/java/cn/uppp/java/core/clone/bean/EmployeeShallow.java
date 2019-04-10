package cn.uppp.java.core.clone.bean;

import lombok.Data;

/**
 * 重写Object.clone()方法，必须实现Cloneable接口，不然会抛出CloneNotSupportedException异常
 */
@Data
public class EmployeeShallow implements Cloneable {
    private String name;
    private EmailShallow emailShallow;

    public EmployeeShallow(String name, EmailShallow emailShallow) {
        this.name = name;
        this.emailShallow = emailShallow;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
