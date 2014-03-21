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
     * @param c    collection to map
     * @param cls  class of implementation of result collection
     * @param f    function to apply
     * @param <T>  type converted values
     * @param <R>  type of result values
     * @param <Ct> collection of converted elements
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



}
