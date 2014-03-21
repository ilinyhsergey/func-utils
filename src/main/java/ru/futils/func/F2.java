package ru.futils.func;

/**
 * Function of 0 arguments.
 *
 * @param <T1> type of 1-st argument
 * @param <T2> type of 2-nd argument
 * @param <R>  type of returned value
 * @author ilinyh.s@gmail.com
 */
public interface F2<T1, T2, R> {
    R apply(T1 a1, T2 a2);
}
