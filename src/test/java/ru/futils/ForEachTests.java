package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

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
    public void nonEmptyList() {
        test(1, 5, 3, 2, 4);
    }

    @Test
    public void emptyList() {
        test();
    }

    @Test
    public void singleInList() {
        test(1);
    }

    @Test
    public void nullArg() {
        final ArrayList<Integer> list2 = new ArrayList<Integer>(0);

        FuncUtils.forEach(null, new F1<Integer, Void>() {
            @Override
            public Void apply(Integer a1) {
                list2.add(a1);
                return null;
            }
        });

        assertTrue(list2.isEmpty());
    }
}
