package com.efimchick.ifmo.collections;

import java.util.*;

class PairStringList<T> extends AbstractList<T> {
    private Object[] array;
    public int position = 0;

    public PairStringList() {
        this.array = new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public boolean add(T t) {
        addSpace();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = t;
                array[i + 1] = t;
            }
        }

        return true;
    }

    @Override
    public void add(int index, T element) {
        addSpace();
        if (index > array.length) {
            throw new IllegalStateException();
        }
        if (index % 2 != 0) {
            index += 1;
        }

        System.arraycopy(array, index, array, index + 2, array.length - 2 - index);


        array[index] = element;
        array[index + 1] = element;
    }

    public void addAll(List al) {
        for (int i = 0; i < al.size(); i++) {
            add((T) al.get(i));
        }

    }

    @Override
    public boolean addAll(int index, Collection<? extends T> al) {

        for (int i = 0; i < al.size(); i++) {
            add(index + i * 2, (T) ((List<T>) al).get(i));
        }
        return true;
    }

    /*@Override
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
    }*/
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

    /*public boolean add(T t, int index) {
        addSpace();
        if (index > array.length + 1) {
            return false;
        }

        for (int i = index; i >= array.length; i--) {
            array[i] = array[i - 1];
        }
        array[index] = t;
        array[index+1] = t;

        return true;
    }*/
    @Override
    public boolean remove(Object element) {
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                if (array.length == 2 || i == array.length - 1) {
                    cutSpace();
                } else {
                    for (int j = i; j < array.length - 2; j++) {
                        array[j] = array[j + 2];
                    }
                    cutSpace();
                }

            }
            return false;
        }

        return true;
    }

    public T remove(int index) {
        T oldValue = (T) array[index];
        for (int i = 0; i < index; i++) {
            if (array.length == 2 || i == array.length - 1) {
                cutSpace();
            } else {
                if (index % 2 != 0) {
                    index -= 1;
                }
                for (int j = index; j < array.length - 2; j++) {
                    array[j] = array[j + 2];
                }
                cutSpace();
            }
        }

        return oldValue;
    }

    public void clear() {
        array = new Object[0];
    }

    @Override
    public T set(int index, T element) {
        T oldValue = null;
        if (index % 2 != 0) {
            index -= 1;
        }
        oldValue = (T) array[index];
        array[index] = element;
        array[index + 1] = element;

        return oldValue;
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
