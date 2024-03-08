package top.ninng.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模拟请求权限注解
 * <p>
 * 使用元注解 @Target 来标记该注解的作用范围(空间范围，在哪些地方可以使用)
 * 使用元注解 @Retention 来标记该注解的作用时间范围(时间范围，在什么时候起作用)
 * 使用元注解 @Inherited 来标记该注解是否可以由子注解来继承
 * 使用元注解 @Documented 来标记该注解是否需要自动生成文档
 * 使用 @interface 关键词来定义注解
 * 在注解内部定义一些相关的属性，一般是方法的形式来定义属性
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    int requestCode() default 0;

    String[] value();
}
