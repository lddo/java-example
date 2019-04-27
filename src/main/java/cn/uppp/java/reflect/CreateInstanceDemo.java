package cn.uppp.java.reflect;

import cn.uppp.java.common.User;

/**
 * 演示创建实例
 */
public class CreateInstanceDemo {
    public static void main(String[] args) {
        // 通过类名，反射创建实例
        User user = (User)createByClassName("cn.uppp.java.common.User");
        System.out.println(user);
        // 通过类型，反射创建实例
        User user2 = createByClassType(User.class);
        System.out.println(user2);
    }

    /**
     * 通过类名创建
     * 注意：这里类名指的是类的全路径
     * @param className
     * @return
     */
    public static Object createByClassName(String className){
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过类型创建
     * 根据参数，动态返回类型
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T createByClassType(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
