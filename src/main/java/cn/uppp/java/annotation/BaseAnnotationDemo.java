package cn.uppp.java.annotation;

import java.lang.annotation.*;

@Documented // 文档
@Retention(RetentionPolicy.RUNTIME) // 保留策略（运行时）
@Target({ElementType.TYPE, ElementType.METHOD}) // 目标类型
public @interface BaseAnnotationDemo {

}
