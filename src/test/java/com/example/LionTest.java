package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predator;

    @Test
    public void getKittensReturnsPredatorKittensCount() throws Exception {
        Lion lion = new Lion("Самец", predator);
        Mockito.when(predator.getKittens()).thenReturn(1);

        int actualKittens = lion.getKittens();

        assertEquals(1, actualKittens);
        Mockito.verify(predator, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Lion lion = new Lion("Самец", predator);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(predator, Mockito.times(1)).eatMeat();
    }

    @Test
    public void lionInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестный пол", predator);
        });
        assertEquals(
                "Используйте допустимые значения пола животного - самей или самка",
                exception.getMessage()
        );
    }
}
