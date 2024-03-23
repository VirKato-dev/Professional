package my.hw;

import my.hw.annotations.After;
import my.hw.annotations.Before;
import my.hw.annotations.Test;

/**
 * Класс для проверки работоспособности собственных аннотаций
 */
@Test
public class DemoTest {

    @Before
    public void before() {
        System.out.println("---\nBefore test");
    }

    @After
    public void after() {
        System.out.println("After test\n---");
    }

    public void test1() {
        System.out.println("Test method 1");
    }

    private void test2() {
        System.out.println("Test method2");
        throw new RuntimeException("Unexpected behavior!");
    }

}
