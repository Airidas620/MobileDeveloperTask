package com.example.android.mobiledevelopertask.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class JSONDataTest {

    @Test
    public void TestUrlDigitsSumWithDifferentURLs() {
        assertEquals(35,JSONData.urlDigitsSum("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg"));
        assertEquals(49,JSONData.urlDigitsSum("https://images.dog.ceo/breeds/hound-blood/n02088466_1563.jpg"));
        assertEquals(33,JSONData.urlDigitsSum("https://images.dog.ceo/breeds/hound-ibizan/n02091244_1037.jpg"));


    }
}