package my.learning;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface MyAnnotation {
        int value() default 5;

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        System.out.println("Hello world!");
        init();
        members();
        fields();

        Object target = Main.class.getConstructor().newInstance();
        for (Method m : Main.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyAnnotation.class)) {
                for (int i = 0; i < m.getAnnotation(MyAnnotation.class).value(); i++) {
                    m.invoke(target);
                }
            }
        }
    }

    public static void init() throws ClassNotFoundException {
        Class<?> c = Class.forName("java.nio.file.FileSystem");
        System.out.println(c);

        Class<?> b = int.class;
        System.out.println(b);
    }

    public static void members() {
        Class<?> a = String.class;
        int mods = a.getModifiers();
        System.out.println(Modifier.isFinal(mods));
        System.out.println(Modifier.isPublic(mods));
    }

    public static void fields() throws NoSuchFieldException, IllegalAccessException {
        Class<?> c = Box.class;
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        Field field = c.getDeclaredField("privField");

        Box box = new Box();

        field.setAccessible(true);
        field.set(box, 100);

        field.setAccessible(false);
        System.out.println(box.privField);
    }

    @MyAnnotation(5)
    public void a1() {
        System.out.println("a1");
    }

    static class Box {
        private int privField;
        public boolean pubField;
    }
}

