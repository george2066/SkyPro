package test;

import impls.IntegerListImpl;
import interfaces.IntegerList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntegerListImplTest {
    private final List<Integer> integersArrayList = new ArrayList<>();
    private final IntegerList integersIntegersList = new IntegerListImpl();

    @BeforeEach
    public void setup() {
        integersArrayList.add(1);
        integersArrayList.add(2);
        integersArrayList.add(3);
        integersArrayList.add(4);
        integersArrayList.add(1);
        integersArrayList.add(5);

        integersIntegersList.add(1);
        integersIntegersList.add(2);
        integersIntegersList.add(3);
        integersIntegersList.add(4);
        integersIntegersList.add(1);
        integersIntegersList.add(5);
    }

    @Test
    void add() {
        integersIntegersList.add(6);
        Assertions.assertEquals(6, integersIntegersList.size());
    }

    @Test
    void testAdd() {
        integersArrayList.add(1, 6);
        integersIntegersList.add(1, 6);
        Assertions.assertEquals(integersArrayList, integersIntegersList.toArray());
    }

    @Test
    void set() {
        integersArrayList.set(1, 3);
        integersIntegersList.set(1, 3);
        Assertions.assertEquals(integersArrayList, integersIntegersList.toArray());
    }

    @Test
    void removeItem() {
        integersArrayList.removeIf(n -> (n == 1));
        integersIntegersList.removeItem(1);
        Assertions.assertEquals(integersArrayList, integersIntegersList.toArray());
    }

    @Test
    void testRemove() {
        integersArrayList.remove(1);
        integersIntegersList.remove(1);
        Assertions.assertEquals(integersArrayList, integersIntegersList.toArray());
    }

    @Test
    void contains() {
        boolean bool = integersArrayList.contains(1);
        Assertions.assertTrue(bool);
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(0, integersIntegersList.indexOf(1));
    }

    @Test
    void lastIndexOf() {
        Integer indexIAL = integersArrayList.lastIndexOf(1);
        Integer indexIIL = integersIntegersList.lastIndexOf(1);
        Assertions.assertEquals(indexIAL, indexIIL);
    }

    @Test
    void get() {
        Assertions.assertEquals(integersArrayList.get(1), integersIntegersList.get(1));
    }

    @Test
    void testEquals() {
        IntegerList newIntegerList = new IntegerListImpl();
        newIntegerList.add(1);
        newIntegerList.add(2);
        newIntegerList.add(3);
        newIntegerList.add(4);
        newIntegerList.add(1);
        newIntegerList.add(5);
        Assertions.assertTrue(integersIntegersList.equals(newIntegerList));
    }

    @Test
    void size() {
        Assertions.assertEquals(integersArrayList.size(), integersIntegersList.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(integersIntegersList.isEmpty());
    }

    @Test
    void clear() {
        integersIntegersList.clear();
        Assertions.assertTrue(integersIntegersList.isEmpty());
    }

    @Test
    void toArray() {
        Assertions.assertEquals(integersIntegersList.toArray(), integersArrayList);
    }

    @Test
    void getList() {
        Integer[] list = new Integer[integersArrayList.size()];
        for (int i = 0; i < integersArrayList.size(); i++) {
            list[i] = integersArrayList.get(i);
        }
        Assertions.assertEquals(Arrays.toString(list), Arrays.toString(integersIntegersList.toArray().toArray()));
    }
}