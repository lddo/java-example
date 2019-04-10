package cn.uppp.java.core.reflect;

import cn.uppp.java.core.common.User;
import cn.uppp.java.core.utils.TestUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 演示获取对象信息
 */
public class GetObjectInfoDemo {
    public static void main(String[] args) {
        // 反射创建实例
        User user = CreateInstanceDemo.createByClassType(User.class);
        // 获取注解
        Annotation[] annotations = getAnnotation(user.getClass());
        TestUtils.outResult(annotations);
        // 获取成员变量
        Field[] fields = getMemberVariable(user.getClass());
        TestUtils.outResult(fields);
        // 获取方法
        Method[] methods = getMethod(user.getClass());
        TestUtils.outResult(methods);
    }

    /**
     * 获取类的注解
     * @param clazz
     */
    public static Annotation[] getAnnotation(Class clazz){
        return clazz.getDeclaredAnnotations();
    }

    /**
     * 获取类的成员变量
     */
    public static Field[] getMemberVariable(Class clazz){
        return clazz.getDeclaredFields();
    }

    /**
     * 获取方法
     * @param clazz
     */
    public static Method[] getMethod(Class clazz){
        return clazz.getDeclaredMethods();
    }
}
