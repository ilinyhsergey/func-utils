package ru.futils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.futils.func.F2;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author ilinyh.s@gmail.com
 */
@RunWith(JUnit4.class)
public class ReduceTests {

    @Test
    public void test1() {
        List<String> list = Arrays.asList("one", "two", "three");
        String reduce = FuncUtils.reduce(list, new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        }, "->");

        assertTrue(reduce.equalsIgnoreCase("->+one+two+three"));
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("one", "two", "three");
        String reduce = FuncUtils.reduce(list, new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        });

        assertTrue(reduce.equalsIgnoreCase("one+two+three"));
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("one");
        String reduce = FuncUtils.reduce(list, new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        });

        assertTrue(reduce.equalsIgnoreCase("one"));
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList();
        String reduce = FuncUtils.reduce(list, new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        });

        assertNull(reduce);
    }

    @Test
    public void test5() {
        String reduce = FuncUtils.reduce((List<String>) null, new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        });

        assertNull(reduce);
    }

    @Test
    public void test6() {
        List<String> list = Arrays.asList();
        String reduce = FuncUtils.reduce(list, new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        }, "initial");

        assertTrue(reduce.equalsIgnoreCase("initial"));
    }

    @Test
    public void test7() {
        String reduce = FuncUtils.reduce((List<String>) null, new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        }, "initial");

        assertNull(reduce);
    }


}
