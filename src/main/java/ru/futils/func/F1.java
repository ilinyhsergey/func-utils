package ru.futils.func;

/**
 * Function of 0 arguments.
 *
 * @param <T1> type of 1-st argument
 * @param <R>  type of returned value
 * @author ilinyh.s@gmail.com
 */
public interface F1<T1, R> {
    R apply(T1 a1);
}
