package com.bookovna.tests.properties;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {

    @Test
    void testTest() {
        String value = System.getProperty("value");
        System.out.println(value);
    }
}
