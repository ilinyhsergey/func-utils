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

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
        assertTrue(FuncUtils.every(list, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        }));
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(2, 4, 6, 7, 8, 10);
        assertFalse(FuncUtils.every(list, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        }));
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList();
        assertTrue(FuncUtils.every(list, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        }));
    }

    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(100);
        assertTrue(FuncUtils.every(list, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        }));
    }

    @Test
    public void test5() {
        List<Integer> list = Arrays.asList(101);
        assertFalse(FuncUtils.every(list, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        }));
    }

    @Test
    public void test6() {
        assertFalse(FuncUtils.every(null, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return false;
            }
        }));
    }

    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(null, null, null);
        assertTrue(FuncUtils.every(list, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 == null;
            }
        }));
    }

}


