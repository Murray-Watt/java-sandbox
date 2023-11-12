package org.mwatt.domain;

public class LazyImpl<T> implements Lazy<T> {
    private T instance;
    final private Lazy<T> builder;

    public LazyImpl(Lazy<T> builder) {
        this.builder = builder;
    }

    public T get() {
        if (instance == null) {
            instance = builder.get();
        }
        return instance;
    }
}
