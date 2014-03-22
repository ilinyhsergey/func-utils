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
public class ForEachTests {

    public void test(Integer... args) {
        List<Integer> list = Arrays.asList(args);
        final ArrayList<Integer> list2 = new ArrayList<Integer>(list.size());

        FuncUtils.forEach(list, new F1<Integer, Void>() {
            @Override
            public Void apply(Integer a1) {
                list2.add(a1);
                return null;
            }
        });

        assertArrayEquals(list.toArray(), list2.toArray());
    }

    @Test
    public void test1() {
        test(1, 5, 3, 2, 4);
    }

    @Test
    public void test2() {
        test();
    }

    @Test
    public void test3() {
        test(1);
    }
}
