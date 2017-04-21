package com.example.jc321013.unitconversion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void conversionMainTest(){
        double original = 1.0;
        double centimeters = 1.0;
        double meters = 100.0;
        double num = centimeters * meters;
        assertTrue(original == num);

    }



    @Test
    public void conversionSettingsTest(){
        double original = 30.48;
        double feet = 1.0;
        double centimeters = 30.48;
        double num = centimeters * feet;
        assertTrue(original == num);

    }

}