package org.example;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class TestOrderExample {

    @BeforeClass
    public static void init() {
        System.out.println("inside before class");
    }

    @Before
    public void setup() {
        System.out.println("inside before... ");
    }

    @After
    public void close() {
        System.out.println("inside after...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("inside after class");
    }

    @Test
    public void test1() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        assertTrue(true);
    }



}