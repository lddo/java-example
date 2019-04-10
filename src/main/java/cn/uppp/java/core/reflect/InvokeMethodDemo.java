package cn.uppp.java.core.reflect;

import cn.uppp.java.core.common.User;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * 演示调用方法
 */
public class InvokeMethodDemo {
    public static void main(String[] args) {
        // 反射创建实例
        User user = CreateInstanceDemo.createByClassType(User.class);
        // 调用方法
        invokeMethod(user);
    }

    /**
     * 反射调用方法
     * @param user
     */
    public static void invokeMethod(User user){
        Method[] methods = GetObjectInfoDemo.getMethod(user.getClass());
        Arrays.stream(methods).forEach(method -> {
            if(method.getName().equals("setName")) {
                try {
                    method.invoke(user, "invoke_method");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(user);
    }
}
