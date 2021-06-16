package com.efimchick.ifmo.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class PairStringList<T> implements List<T> {
    private Object[] array;
    private int position = 0;

    public PairStringList() {
        this.array = new Object[0];
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        T oldValue = null;
        if (index < array.length - 1) {
            oldValue = (T) array[index];
            array[index] = element;
            array[index + 1] = element;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        addSpace();
        if (index > array.length) {
            throw new IllegalStateException();
        }
        array[index] = element;
        array[index++] = element;
    }

    @Override
    public T remove(int index) {
        T oldValue = null;
        if (index < array.length) {
            oldValue = (T) array[index];
            for (int i = index; i < array.length - 2; i++) {
                array[i] = array[i + 2];
            }
            cutSpace();
        }
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                index = i;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = 0; i >= array.length; i--) {
            if (array[i] != null) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {

            @Override
            public boolean hasNext() {
                return position < array.length;
            }

            @Override
            public T next() {
                return (T) array[position++];
            }

            @Override
            public boolean hasPrevious() {
                return position>array.length;
            }

            @Override
            public T previous() {
                return (T)array[position--];
            }

            @Override
            public int nextIndex() {
                return position++;
            }

            @Override
            public int previousIndex() {
                return position--;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {
                addSpace();
                array[position] = t;
                array[position++] = t;
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
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
        return (T1[]) array;
    }

    @Override
    public boolean add(T t) {
        addSpace();
        array[position] = t;
        array[position++] = t;

        return true;
    }

    public boolean add(T t, int index) {
        addSpace();
        if (index > array.length + 1) {
            return false;
        }

        for (int i = index; i >= array.length; i--) {
            array[i] = array[i - 1];
        }
        array[index] = t;
        array[index++] = t;

        return true;
    }

    @Override
    public boolean remove(Object element) {
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                for (int j = i; j < array.length - 2; j++) {
                    array[j] = array[j + 2];
                    cutSpace();
                }
            }
            return false;
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
    public boolean addAll(int index, Collection<? extends T> c) {
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

    private void addSpace() {
        Object[] newArray = new Object[array.length + 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void cutSpace() {
        Object[] newArray = new Object[array.length - 2];
        System.arraycopy(array, 0, newArray, 0, array.length - 2);
        array = newArray;
    }


}
