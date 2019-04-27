package cn.uppp.java.pattern.singleton;

/**
 * 懒汉式单例
 * 多线程下会有性能问题
 */
public class LazySingleton {
    private Integer id;
    private String name;

    // volatile 避免指令重排导致创建对象时，返回空引用
    private volatile static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        // 双检锁，避免性能问题
        if (lazySingleton == null)
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) lazySingleton = new LazySingleton();
            }
        return lazySingleton;
    }
}
