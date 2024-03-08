package top.ninng.annotation;

/**
 * 使用注解 {@link Permission}
 */
public class AnnotationUseExample {

    public void f() {
        System.out.println("f");
    }


    @Permission(value = {"android.permission.CALL_PHONE"}, requestCode = 8)
    public void f1() {
        System.out.println("f1");
    }

    @Permission(value = {"android.permission.CALL_PHONE", "android.permission.CAMERA"}, requestCode = 10)
    public void requestPermission() {
        //其他逻辑
        System.out.println("拥有权限");
    }
}
