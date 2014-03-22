package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author ilinyh.s@gmail.com
 */
@RunWith(JUnit4.class)
public class SomeTests {

    @Test
    public void filterTest1() {
        List<String> list = Arrays.asList("one", "two", "three");
        assertTrue(FuncUtils.some(list, new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return "two".equalsIgnoreCase(a1);
            }
        }));
    }

    @Test
    public void filterTest2() {
        List<String> list = Arrays.asList("one", "two", "three");
        assertFalse(FuncUtils.some(list, new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return "zero".equalsIgnoreCase(a1);
            }
        }));
    }

    @Test
    public void filterTest3() {
        List<String> list = new ArrayList<String>(0);
        assertFalse(FuncUtils.some(list, new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return "zero".equalsIgnoreCase(a1);
            }
        }));
    }

    @Test
    public void filterTest4() {
        List<String> list = new ArrayList<String>(1){{
            add(null);
        }};
        assertFalse(FuncUtils.some(list, new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return "zero".equalsIgnoreCase(a1);
            }
        }));
    }

    @Test
    public void filterTest5() {
        List<String> list = new ArrayList<String>(1){{
            add(null);
        }};
        assertTrue(FuncUtils.some(list, new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return a1 == null;
            }
        }));
    }

    @Test
    public void filterTest6() {
        assertFalse(FuncUtils.some(null, new F1<String, Boolean>() {
            @Override
            public Boolean apply(String a1) {
                return true;
            }
        }));
    }

}
