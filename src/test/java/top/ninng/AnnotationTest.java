package top.ninng;

import org.junit.Test;
import top.ninng.annotation.AnnotationUseExample;
import top.ninng.annotation.Permission;

import java.lang.reflect.Method;

/**
 * 注解测试
 */
public class AnnotationTest {

    @Test
    public void test() {
        try {
            AnnotationUseExample annotationUseExample = new AnnotationUseExample();
            // 获取 AnnotationExample 的 Class 对象
            Class<?> cls = annotationUseExample.getClass();
            // 获取 AnnotationExample 类中的方法
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                // 过滤不含自定义注解 AnnotationInfo 的方法
                boolean isHasAnnotation = method.isAnnotationPresent(Permission.class);
                if (isHasAnnotation) {
                    method.setAccessible(true);
                    // 获取方法上的注解
                    Permission aInfo = method.getAnnotation(Permission.class);
                    if (aInfo == null) {
                        break;
                    }
                    // 解析注解上对应的信息
                    System.out.println(aInfo);
                    System.out.print("run: ");
                    method.invoke(annotationUseExample);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
