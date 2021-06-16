package com.efimchick.ifmo.collections;

import java.util.*;

class SortedByAbsoluteValueIntegerSet<T> implements Set<T>, Comparator<T> {
    private Object[] array = {};

    public SortedByAbsoluteValueIntegerSet() {
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
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        addSpace();
        for (int i = 0; i < array.length; i++) {
            if (t.equals(array[i])) {
                return false;
            } else {
                array[i] = t;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                array[i] = null;
                cutSpace();
                return true;
            } else {
                return false;
            }
        }
        return true;
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int compare(T o1, T o2) {
        int b1 = (int) o1;
        int b2 = (int) o2;
        return Integer.valueOf(Math.abs(b1)).compareTo(Integer.valueOf(Math.abs(b2)));
    }

    private void addSpace() {
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void cutSpace() {
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, array.length-1);
        array = newArray;
    }
}
