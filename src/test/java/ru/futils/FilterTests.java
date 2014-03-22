package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * @author ilinyh.s@gmail.com
 */
@RunWith(JUnit4.class)
public class FilterTests {

    public void test(Integer[] data, Integer[] expected) {

        ArrayList<Integer> result = FuncUtils.filter(Arrays.asList(data), ArrayList.class, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        });

        assertArrayEquals(result.toArray(), expected);
    }

    @Test
    public void test1() {
        test(new Integer[]{1, 4, 5, 3, 2}, new Integer[]{4, 2});
    }

    @Test
    public void test2() {
        test(new Integer[0], new Integer[0]);
    }

    @Test
    public void test3() {
        test(new Integer[]{1}, new Integer[0]);
    }

    @Test
    public void test4() {
        test(new Integer[]{20}, new Integer[]{20});
    }

    @Test
    public void test5() {
        Collection<Object> filter = FuncUtils.filter(null, ArrayList.class, new F1<Object, Boolean>() {
            @Override
            public Boolean apply(Object a1) {
                return true;
            }
        });
        assertNull(filter);
    }

}
