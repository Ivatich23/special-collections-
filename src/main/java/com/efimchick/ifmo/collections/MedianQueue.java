package com.efimchick.ifmo.collections;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

class MedianQueue<T> implements Queue<T> {
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
        if (array[array.length] != null) {
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
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[array.length];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        addSpace();
        array[position] = t;
        position++;
        return true;
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        for (int i = 0; i < array.length; i++) {
            int min = (int) array[i];
            int pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min >  (int)array[j]){
                    min = (Integer)array[j];
                    pos = j;
                }
                T tempValue = (T) array[i];
                array[i]=array[pos];
                array[pos]=tempValue;
            }

        }
        return (T) array[array.length/2];
    }


    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
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
