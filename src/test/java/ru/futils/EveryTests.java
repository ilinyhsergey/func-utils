package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F1;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author ilinyh.s@gmail.com
 */
@RunWith(JUnit4.class)
public class EveryTests {

    private F1<Integer, Boolean> f;
    private F1<Integer, Boolean> fFalse;

    public EveryTests() {
        f = new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        };

        fFalse = new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return false;
            }
        };
    }

    @Test
    public void nonEmptyList() {
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
        assertTrue(FuncUtils.every(list, f));
        assertFalse(FuncUtils.every(list, fFalse));

        list = Arrays.asList(2, 4, 6, 7, 8, 10);
        assertFalse(FuncUtils.every(list, f));
        assertFalse(FuncUtils.every(list, fFalse));
    }

    @Test
    public void emptyList() {
        List<Integer> list = Arrays.asList();
        assertTrue(FuncUtils.every(list, f));
        assertTrue(FuncUtils.every(list, fFalse));
    }

    @Test
    public void singleInList() {
        List<Integer> list = Arrays.asList(100);
        assertTrue(FuncUtils.every(list, f));

        list = Arrays.asList(101);
        assertFalse(FuncUtils.every(list, f));
    }

    @Test
    public void nullArg() {
        assertTrue(FuncUtils.every(null, f));
        assertTrue(FuncUtils.every(null, fFalse));
    }

}


