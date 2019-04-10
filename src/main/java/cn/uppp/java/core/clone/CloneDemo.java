package cn.uppp.java.core.clone;

import cn.uppp.java.clone.bean.*;
import cn.uppp.java.core.clone.bean.*;

import java.io.IOException;

/**
 * 浅克隆、深克隆
 */
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        testShallowClone();
        testDeepClone();
        testDeepCloneOfSerialize();
    }

    /**
     * 浅克隆
     * 特点：浅克隆能克隆基本数据类型，引用类型只克隆引用地址，只要任一实例修改，会影响所有克隆的实例
     */
    private static void testShallowClone() throws CloneNotSupportedException {
        EmailShallow emailShallow = new EmailShallow("周六八点正，学习浅克隆！");
        EmployeeShallow employeeShallow = new EmployeeShallow("tom", emailShallow);

        EmployeeShallow employeeShallow1 = (EmployeeShallow) employeeShallow.clone();
        // 修改
        employeeShallow1.getEmailShallow().setContent("周六九点半，先学习浅克隆，再学习深克隆！");

        System.out.println(employeeShallow.getName() + "->" + employeeShallow.getEmailShallow().getContent());
        System.out.println(employeeShallow1.getName() + "->" + employeeShallow1.getEmailShallow().getContent());
    }

    /**
     * 深克隆——对引用类型也进行克隆
     */
    private static void testDeepClone() throws CloneNotSupportedException {
        EmailDeep emailDeep = new EmailDeep("周六八点正，学习浅克隆！");
        EmployeeDeep employeeDeep = new EmployeeDeep("jerry", emailDeep);

        EmployeeDeep employeeDeep1 = (EmployeeDeep) employeeDeep.clone();
        // 修改，此时引用对象也被克隆，更改不会影响其他克隆对象
        employeeDeep1.getEmailDeep().setContent("周六九点半，先学习浅克隆，再学习深克隆！");

        System.out.println(employeeDeep.getName() + "->" + employeeDeep.getEmailDeep().getContent());
        System.out.println(employeeDeep1.getName() + "->" + employeeDeep1.getEmailDeep().getContent());
    }

    /**
     * 深克隆之序列化
     */
    private static void testDeepCloneOfSerialize() throws IOException, ClassNotFoundException {
        EmailDeepSerialize emailDeepSerialize = new EmailDeepSerialize("周六八点正，学习浅克隆！");
        EmployeeDeepSerialize employeeDeepSerialize = new EmployeeDeepSerialize("tony", emailDeepSerialize);

        EmployeeDeepSerialize employeeDeepSerialize1 = employeeDeepSerialize.deepClone();
        // 修改，此时引用对象也被克隆，更改不会影响其他克隆对象
        employeeDeepSerialize1.getEmailDeepSerialize().setContent("周六九点半，先学习浅克隆，再学习深克隆！");

        System.out.println(employeeDeepSerialize.getName() + "->" + employeeDeepSerialize.getEmailDeepSerialize().getContent());
        System.out.println(employeeDeepSerialize1.getName() + "->" + employeeDeepSerialize1.getEmailDeepSerialize().getContent());
    }
}
