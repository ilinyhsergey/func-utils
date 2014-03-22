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
public class SomeTests {

    private F1<String, Boolean> f0;
    private F1<String, Boolean> f1;
    private F1<String, Boolean> fTrue;

    public SomeTests() {
        f0 = new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return "zero".equalsIgnoreCase(a1);
            }
        };

        f1 = new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return "one".equalsIgnoreCase(a1);
            }
        };

        fTrue = new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return true;
            }
        };
    }

    @Test
    public void nonEmptyList() {
        List<String> list = Arrays.asList("one", "two", "three");

        assertTrue(FuncUtils.some(list, f1));
        assertFalse(FuncUtils.some(list, f0));
        assertTrue(FuncUtils.some(list, fTrue));
    }

    @Test
    public void emptyList() {
        List<String> list = Arrays.asList();
        assertFalse(FuncUtils.some(list, f0));
        assertFalse(FuncUtils.some(list, fTrue));
    }

    @Test
    public void singleInList() {
        List<String> list = Arrays.asList("one");
        assertFalse(FuncUtils.some(list, f0));
        assertTrue(FuncUtils.some(list, f1));
        assertTrue(FuncUtils.some(list, fTrue));
    }

    @Test
    public void nullArg() {
        assertFalse(FuncUtils.some(null, f0));
        assertFalse(FuncUtils.some(null, f1));
        assertFalse(FuncUtils.some(null, fTrue));
    }

}
