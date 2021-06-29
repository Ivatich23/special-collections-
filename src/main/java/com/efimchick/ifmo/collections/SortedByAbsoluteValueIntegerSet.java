package com.efimchick.ifmo.collections;

import java.util.*;

class SortedByAbsoluteValueIntegerSet<T> extends AbstractSet {
    private Object[] array = {};
    private int position = 0;

    public SortedByAbsoluteValueIntegerSet() {
        this.array = new Object[0];
    }

    @Override
    public Iterator iterator() {
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

    public boolean add(Object t) {
        addSpace();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = t;
            }
        }

        Arrays.sort(array, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                try {
                    if (Math.abs((Integer) o1) > (Math.abs((Integer) o2))) {
                        return 1;
                    } else if (Math.abs((Integer) o1) < (Math.abs((Integer) o2))) {
                        return -1;
                    } else if (Math.abs((Integer) o1) == (Math.abs((Integer) o2))) {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 1;
            }
        });
        return true;
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
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SortedByAbsoluteValueIntegerSet<?> that = (SortedByAbsoluteValueIntegerSet<?>) o;
        return position == that.position &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), position);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                for(int j = i;j<array.length-1;j++){
                    array[j]=array[j+1];
                }
                cutSpace();
                position=0;
                return true;
            }
        }
        return false;
    }


    @Override
    public void clear() {
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
