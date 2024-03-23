package my.hw;

import my.hw.starter.TestStarter;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (TestStarter.execute(DemoTest.class)) {
            System.out.println("\nОжидаемый результат выполнения ))");
        } else {
            System.out.println("\nЧто-то пошло не так ((");
        }
    }
}
