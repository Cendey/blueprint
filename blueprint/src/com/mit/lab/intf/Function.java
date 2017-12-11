package com.mit.lab.intf;

/**
 * <p>Title: MIT Lib Project</p>
 * <p>Description: com.mit.lab.intf.Function</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: MIT Lab Co., LTD.</p>
 *
 * @author <chao.deng@mit.edu>
 * @version 1.0
 * @since 12/02/2017
 */
public interface Function<T, U> {

    U apply(T arg);

    default <R> Function<Function<U, R>, Function<Function<T, U>, Function<T, R>>> higherCompose() {
        return x -> y -> z -> x.apply(y.apply(z));
    }

    default <R> Function<R, U> compose(Function<T, U> outer, Function<R, T> inner) {
        return arg -> outer.apply(inner.apply(arg));
    }
}
