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
public class ReduceRightTests {

    private F2<String, String, String> f;

    public ReduceRightTests() {
        f = new F2<String, String, String>() {
            @Override
            public String apply(String a1, String a2) {
                return a1 + "+" + a2;
            }
        };
    }

    @Test
    public void nonEmptyList() {
        List<String> list = Arrays.asList("one", "two", "three");

        String reduce = FuncUtils.reduceRight(list, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero+three+two+one"));

        reduce = FuncUtils.reduceRight(list, f);
        assertTrue(reduce.equalsIgnoreCase("three+two+one"));

        String[] arr = {"one", "two", "three"};

        reduce = FuncUtils.reduceRight(arr, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero+three+two+one"));

        reduce = FuncUtils.reduceRight(arr, f);
        assertTrue(reduce.equalsIgnoreCase("three+two+one"));
    }

    @Test
    public void singleInList() {
        List<String> list = Arrays.asList("one");

        String reduce = FuncUtils.reduceRight(list, f);
        assertTrue(reduce.equalsIgnoreCase("one"));

        reduce = FuncUtils.reduceRight(list, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero+one"));

        String[] arr = {"one"};

        reduce = FuncUtils.reduceRight(arr, f);
        assertTrue(reduce.equalsIgnoreCase("one"));

        reduce = FuncUtils.reduceRight(arr, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero+one"));
    }

    @Test
    public void emptyList() {
        List<String> list = Arrays.asList();

        String reduce = FuncUtils.reduceRight(list, f);
        assertNull(reduce);

        reduce = FuncUtils.reduceRight(list, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero"));

        String[] arr = {};

        reduce = FuncUtils.reduceRight(arr, f);
        assertNull(reduce);

        reduce = FuncUtils.reduceRight(arr, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero"));
    }

    @Test
    public void nullArg() {
        String reduce = FuncUtils.reduceRight((List<String>) null, f);
        assertNull(reduce);

        reduce = FuncUtils.reduceRight((List<String>) null, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero"));

        reduce = FuncUtils.reduceRight((String[]) null, f);
        assertNull(reduce);

        reduce = FuncUtils.reduceRight((String[]) null, f, "zero");
        assertTrue(reduce.equalsIgnoreCase("zero"));
    }

}
