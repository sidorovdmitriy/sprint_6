package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest extends TestCase {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String UNSUPPORTED_SEX = "Указан неверный пол животного";
    private static final String TEXT_EXCEPTION = "Используйте допустимые значения пола животного - самец или самка";
    private Lion lion;
    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeException() {
        Throwable throwable = catchThrowable(() -> {
            lion = new Lion(UNSUPPORTED_SEX, feline);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(TEXT_EXCEPTION);
    }
    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(MALE, feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
    @Test
    public void testFemaleHaveMane() throws Exception {
        lion = new Lion(FEMALE, feline);
        assertFalse(lion.doesHaveMane());
    }
}