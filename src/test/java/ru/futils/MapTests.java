package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author ilinyh.s@gmail.com
 */
@RunWith(JUnit4.class)
public class MapTests {

    public void test(Integer... args) {
        List<Integer> list = Arrays.asList(args);
        ArrayList<Integer> list2 = FuncUtils.map(list, ArrayList.class, new F1<Integer, Integer>() {
            @Override
            public Integer apply(Integer a1) {
                return a1;
            }
        });

        assertArrayEquals(list.toArray(), list2.toArray());
    }

    @Test
    public void test1() {
        test(1, 4, 5, 3, 2);
    }

    @Test
    public void test2() {
        test();
    }

    public void test3() {
        test(1);
    }

}
