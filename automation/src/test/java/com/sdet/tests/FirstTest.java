package com.sdet.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    @Test
    void verifyJavaAndJUnitAreWorking() {

        String expected = "Senior SDET";
        String actual = "Senior SDET";

        assertEquals(expected, actual);
    }
}