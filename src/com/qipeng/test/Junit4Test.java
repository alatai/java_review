package com.qipeng.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/11 21:22
 */
public class Junit4Test {

    @Before
    public void before() {
        System.out.println("@Before");
    }

    @Test
    public void test() {
        System.out.println("@Test");
        assertEquals(5 + 5, 10);
    }

    @Test(timeout = 50)
    public void testTime() {
        System.out.println("@Test(timeout = 50)");
        assertEquals(5 + 5, 10);
    }

    @Test(expected = ArithmeticException.class)
    public void testExpected() {
        System.out.println("@Test(expected = Exception.class)");
        throw new ArithmeticException();
    }
}
