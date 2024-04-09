package org.mwatt.domain;

public class Lazy<T> implements LazyBuilder<T> {
    private T instance;
    final private LazyBuilder<T> builder;
    private final Object lock = new Object();

    public Lazy(LazyBuilder<T> builder) {
        this.builder = builder;
    }

    public T get() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = builder.get();
                }
            }

            instance = builder.get();
        }
        return instance;
    }
}
