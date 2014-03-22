package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * @author ilinyh.s@gmail.com
 */
@RunWith(JUnit4.class)
public class MapTests {

    private F1<Integer, Integer> f;

    public MapTests() {
        f = new F1<Integer, Integer>() {
            @Override
            public Integer apply(Integer a1) {
                return a1;
            }
        };
    }

    public void test(Integer... args) {
        List<Integer> list = Arrays.asList(args);
        ArrayList<Integer> list2 = FuncUtils.map(list, ArrayList.class, f);

        assertArrayEquals(list.toArray(), list2.toArray());
    }

    @Test
    public void nonEmptyList() {
        test(1, 4, 5, 3, 2);
    }

    @Test
    public void emptyList() {
        test();
    }

    public void singleInList() {
        test(1);
    }

    @Test
    public void nullArg() {
        ArrayList<Integer> list2 = FuncUtils.map(null, ArrayList.class, f);
        assertNull(list2);
    }

}
