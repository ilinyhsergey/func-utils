package ru.futils;

import ru.futils.func.F1;

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


}
