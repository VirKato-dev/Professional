package my.hw;

import my.hw.annotations.After;
import my.hw.annotations.Before;
import my.hw.annotations.Test;

/**
 * Класс для проверки работоспособности собственных аннотаций
 */
@Test
public class DemoTest {

    private int global;

    @Before
    public void before() {
        System.out.println("---\nBefore test (" + global + ")");
    }

    @After
    public void after() {
        System.out.println("After test ("+ global +")\n---");
    }

    public void test1() {
        global++;
        System.out.println("Test method 1");
    }

    private void test2() {
        System.out.println("Test method2");
        global++;
        throw new RuntimeException("Unexpected behavior!");
    }

}
