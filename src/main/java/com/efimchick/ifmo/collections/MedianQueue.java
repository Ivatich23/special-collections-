package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue<T> extends AbstractQueue {
    Object[] array;
    int position = 0;

    public MedianQueue() {
        this.array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        if (array[array.length - 1] != null) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return position < array.length;
            }

            @Override
            public Object next() {
                return array[position++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[array.length];
    }


    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                cutSpace();
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean offer(Object o) {
        addSpace();
        array[array.length - 1] = o;
        return true;
    }

    @Override
    public T poll() {
        T valueBeforeDel = null;

        Arrays.sort(array);
        if (array.length % 2 != 0) {
            valueBeforeDel = (T) array[array.length / 2];
            for (int i = array.length / 2; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            cutSpace();
            position = 0;
            return valueBeforeDel;
        } else {

            valueBeforeDel = (T) array[array.length / 2 - 1];
            for (int i = array.length / 2 - 1; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            cutSpace();
            position = 0;
            return valueBeforeDel;
        }
    }

    @Override
    public Object peek() {

        Arrays.sort(array);
        if (array.length % 2 != 0) {
            return (T) array[array.length / 2];
        } else {
            return (T) array[array.length / 2 - 1];
        }
    }


    private void addSpace() {
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void cutSpace() {
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        array = newArray;
    }
}
