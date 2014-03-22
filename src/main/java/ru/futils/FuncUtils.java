package ru.futils;

import ru.futils.func.F1;
import ru.futils.func.F2;

import java.util.Collection;

/**
 * Utils for using functional programming paradigm in java.
 *
 * @author ilinyh.s@gmail.com
 */
public final class FuncUtils {

    private FuncUtils() {
    }

    /**
     * Applies a function f to each element of the collection c
     *
     * @param c   collection
     * @param f   function to apply
     * @param <T> type of collection elements
     */
    public static <T> void forEach(Collection<T> c, F1<T, Void> f) {
        if (c == null)
            return;

        for (T t : c)
            f.apply(t);
    }

    /**
     * Map collection c to other collection using conversion function f
     *
     * @param c    collection to map
     * @param cls  class of implementation of result collection
     * @param f    function to apply
     * @param <T>  type converted values
     * @param <R>  type of result values
     * @param <Ct> type of collection to map
     * @param <Cr> type of result collection
     * @return instance of cls which contain mapped collection
     */
    @SuppressWarnings("unchecked")
    public static <T, R, Ct extends Collection<T>, Cr extends Collection<R>>
    Cr map(Ct c, Class<? extends Collection> cls, F1<T, R> f) {
        if (c == null)
            return null;

        Cr res;
        try {
            res = (Cr) cls.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        for (T t : c)
            res.add(f.apply(t));

        return res;
    }

    /**
     * Filter collection c using predicate function f
     *
     * @param c    collection to filter
     * @param cls  class of implementation of result collection
     * @param f    function predicate
     * @param <T>  type of collection element
     * @param <Ct> type of collection to filter
     * @param <Cr> type of filtered collection
     * @return instance of cls which contain filtered collection
     */
    @SuppressWarnings("unchecked")
    public static <T, Ct extends Collection<T>, Cr extends Collection<T>>
    Cr filter(Ct c, Class<? extends Collection> cls, F1<T, Boolean> f) {
        if (c == null)
            return null;

        Cr res;
        try {
            res = (Cr) cls.newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        for (T t : c)
            if (f.apply(t))
                res.add(t);

        return res;
    }

    /**
     * Check if collection c contain at least one element satisfies the predicate f
     *
     * @param c    collection to check
     * @param f    predicate
     * @param <T>  type of collection element
     * @param <Ct> type of collection
     * @return return true if at least one element of the collection satisfies the predicate f, otherwise return false
     */
    public static <T, Ct extends Collection<T>>
    Boolean some(Ct c, F1<T, Boolean> f) {
        if (c == null)
            return false;

        for (T t : c)
            if (f.apply(t))
                return true;

        return false;
    }

    /**
     * Check if collection c contain all element satisfies the predicate f
     *
     * @param c    collection to check
     * @param f    predicate
     * @param <T>  type of collection element
     * @param <Ct> type of collection
     * @return return true if all elements of the collection satisfies the predicate f, otherwise return false
     */
    public static <T, Ct extends Collection<T>>
    Boolean every(Ct c, F1<T, Boolean> f) {
        if (c == null)
            return false;

        for (T t : c)
            if (!f.apply(t))
                return false;

        return true;
    }

    /**
     * Convolution method. Combines elements of the array a from right to left.
     *
     * @param a   array to combine
     * @param f   function of 2 arguments,
     *            first argument of f takes the value calculated in the previous step,
     *            second argument of f takes the next value of the array
     * @param i   initial value to combine
     * @param <T> type of array elements
     * @return combined value represented by the formula:
     * if i is expected value equals <code>f (f (f (f (i,a[0]), a[1]), a[2]), ...)</code>
     * if i is null value equals  <code>f (f (f (a[0], a[1]), a[2]), ...)</code>
     */
    public static <T> T reduce(T[] a, F2<T, T, T> f, T i) {
        if (a == null || a.length == 0)
            return i;

        T ret = a[0];

        if (i != null)
            ret = f.apply(i, ret);

        int length = a.length;

        for (int id = 1; id < length; ++id)
            ret = f.apply(ret, a[id]);

        return ret;
    }

    @SuppressWarnings("unchecked")
    public static <T, Ct extends Collection<T>> T reduce(Ct c, F2<T, T, T> f) {
        return c == null ? null : reduce((T[]) c.toArray(), f);
    }

    public static <T> T reduce(T[] a, F2<T, T, T> f) {
        return reduce(a, f, null);
    }

    @SuppressWarnings("unchecked")
    public static <T, Ct extends Collection<T>> T reduce(Ct c, F2<T, T, T> f, T i) {
        return c == null ? null : reduce((T[]) c.toArray(), f, i);
    }
}
