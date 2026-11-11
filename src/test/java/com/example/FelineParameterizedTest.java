package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expectedKittensCount;

    public FelineParameterizedTest(int kittensCount, int expectedKittensCount) {
        this.kittensCount = kittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters(name = "Тест {index}: передано котят = {0}, ожидается = {1}")
    public static Object[][] getKittensData() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5}
        };
    }

    @Test
    public void getKittensWithParamReturnsSameCount() {
        Feline feline = new Feline();
        assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }
}
