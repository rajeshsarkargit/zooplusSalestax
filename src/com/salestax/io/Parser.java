package com.salestax.io;

import java.io.Closeable;
import java.util.stream.Stream;

public interface Parser<U> extends Iterable<U>, Closeable {

    public Parser<U> parse();

    public Stream<U> stream();

}
