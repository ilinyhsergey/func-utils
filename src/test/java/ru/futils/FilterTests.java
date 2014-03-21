package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F1;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author ilinyh.s@gmail.com
 */
@RunWith(JUnit4.class)
public class FilterTests {

    public void filterTest(Integer[] data, Integer[] expected) {

        ArrayList<Integer> result = FuncUtils.filter(Arrays.asList(data), ArrayList.class, new F1<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer a1) {
                return a1 % 2 == 0;
            }
        });

        assertArrayEquals(result.toArray(), expected);
    }

    @Test
    public void filterTest1() {
        filterTest(new Integer[]{1, 4, 5, 3, 2}, new Integer[]{4, 2});
    }

    @Test
    public void filterTest2() {
        filterTest(new Integer[0], new Integer[0]);
    }

    @Test
    public void filterTest3() {
        filterTest(new Integer[]{1}, new Integer[0]);
    }

    @Test
    public void filterTest4() {
        filterTest(new Integer[]{20}, new Integer[]{20});
    }

}
