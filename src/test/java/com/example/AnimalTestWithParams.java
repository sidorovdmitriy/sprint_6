package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTestWithParams {
    private Animal animal;
    private static final String HERBIVORE = "Травоядное";
    private static final String PREDATOR = "Хищник";
    private static final List<String> FOODS_HERBIVORE = List.of("Трава", "Различные растения");
    private static final List<String> FOODS_PREDATOR = List.of("Животные", "Птицы", "Рыба");

    private String animalKind;
    private List<String> foods;

    public AnimalTestWithParams(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {HERBIVORE, FOODS_HERBIVORE},
                {PREDATOR, FOODS_PREDATOR}
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals("Еда не соответствует виду животного",
                foods, actual);
    }
}
