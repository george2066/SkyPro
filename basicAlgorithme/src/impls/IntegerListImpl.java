package impls;

import interfaces.IntegerList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] integers = new Integer[0];

    @Override
    public void add(Integer item) {
        Integer[] newIntegers = new Integer[size() + 1];
        for (int i = 0; i < size(); i++) {
            newIntegers[i] = this.integers[i];
        }
        newIntegers[size()] = item;
        this.integers = newIntegers;
    }

    @Override
    public void add(int index, Integer item) {
        Integer[] prevIntegers = Arrays.copyOfRange(this.integers, 0, index);
        Integer[] nextIntegers = Arrays.copyOfRange(this.integers, index, this.integers.length);
        Integer[] newList = new Integer           [this.integers.length + 1];
        int n = 0;
        for (int i = 0; i < prevIntegers.length; i++) {
            newList[i] = prevIntegers[i];
            n = i;
        }
        newList[n + 1] = item;
        n += 2;
        int k = 0;
        for (int i = n; i < newList.length; i++) {
            newList[i] = nextIntegers[k];
            k += 1;
        }
        this.integers = newList;
    }

    @Override
    public void set(int index, Integer item) {
        this.integers[index] = item;
    }

    @Override
    public void removeItem(Integer item) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < this.integers.length; i++) {
            if (this.integers[i].equals(item)) {
                index = i;
                break;
            }
        }
        Integer[] prevStrings = Arrays.copyOfRange(this.integers, 0, index);
        Integer[] nextStrings = Arrays.copyOfRange(this.integers, index + 1, this.integers.length);
        Integer[] result = new Integer[prevStrings.length + nextStrings.length];
        System.arraycopy(prevStrings, 0, result, 0, prevStrings.length);
        System.arraycopy(nextStrings, 0, result, prevStrings.length, nextStrings.length);
        this.integers = result;
    }

    @Override
    public void remove(int index) {
        Integer item = this.integers[index];
        removeItem(item);
    }

    @Override
    public boolean contains(Integer element) {
        int index = indexOf(element);
        return index >= 0;
    }

    @Override
    public int indexOf(Integer element) {
        for (int i = 0; i < size(); i--) {
            if (this.integers[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size() - 1; i >= 0; i--) {
            if (this.integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return this.integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList.size() != size()) {
            return false;
        } else {
            for (int i = 0; i < this.integers.length; i++) {
                if (!Objects.equals(this.integers[i], otherList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.integers.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        this.integers = new Integer[0];
    }

    @Override
    public List<Integer> toArray() {
        return Arrays.asList(this.integers);
    }

    @Override
    public Object getList() {
        return this.integers;
    }
}
