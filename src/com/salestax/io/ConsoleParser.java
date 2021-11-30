package com.salestax.io;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public abstract class ConsoleParser<I> implements Parser<I> {

    private ItemIterator itemIterator = new ItemIterator();

    @Override
    public Iterator<I> iterator() {
        return itemIterator;
    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub

    }

//    @Override
//    public ConsoleParser<I> parse() {
//        return new ConsoleParser<I>();
//    }

    @Override
    public Stream<I> stream() {
        return StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED),
                        false);
    }

    class ItemIterator implements Iterator<I> {
        private I current;

        private I getNextItem() {
            try {
                return ConsoleParser.this.nextItem();
            } catch (final Exception e) {
                throw new IllegalStateException(e.getClass().getSimpleName()
                                + " reading next item: " + e.toString(), e);
            }
        }

        @Override
        public boolean hasNext() {
            // if (ConsoleParser.this.isClosed()) {
            // return false;
            // }
            if (this.current == null) {
                this.current = this.getNextItem();
            }

            return this.current != null;
        }

        @Override
        public I next() {
            // if (ConsoleParser.this.isClosed()) {
            // throw new NoSuchElementException("Console not available");
            // }
            I next = this.current;
            this.current = null;

            if (next == null) {
                // hasNext() wasn't called before
                next = this.getNextItem();
                if (next == null) {
                    throw new NoSuchElementException("No more Items available");
                }
            }

            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public abstract I nextItem();

    public boolean isClosed() {
        return false;
    }
}
