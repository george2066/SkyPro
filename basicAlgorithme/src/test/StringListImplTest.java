package test;

import impls.StringListImpl;
import interfaces.StringList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringListImplTest {
    private final List<String> listStringTest = new ArrayList<>();
    private final StringList stringList = new StringListImpl();

    @BeforeEach
    public void setup() {
        listStringTest.add("qwerty");
        listStringTest.add("asdfgh");
        listStringTest.add("zxcvbn");
        listStringTest.add("123456");
        listStringTest.add("qwerty");

        stringList.add("qwerty");
        stringList.add("asdfgh");
        stringList.add("zxcvbn");
        stringList.add("123456");
        stringList.add("qwerty");
    }
    @Test
    void add() {
        Assertions.assertEquals(listStringTest, stringList.toArray());
    }

    @Test
    void testAdd() {
        String[] lst = new String[] {"qwerty", "asdfgh", "george2066", "zxcvbn", "123456", "qwerty"};
        stringList.add(2, "george2066");
        Assertions.assertEquals(Arrays.toString(lst), Arrays.toString(stringList.toArray().toArray()));
    }

    @Test
    void set() {
        String[] lst = new String[] {"qwerty", "asdfgh", "george2066", "123456", "qwerty"};
        stringList.set(2, "george2066");
        Assertions.assertEquals(Arrays.toString(lst), Arrays.toString(stringList.toArray().toArray()));
    }

    @Test
    void remove() {
        String[] lst = new String[] {"qwerty", "asdfgh", "zxcvbn", "qwerty"};
        stringList.remove("123456");
        Assertions.assertEquals(Arrays.toString(lst), Arrays.toString(stringList.toArray().toArray()));
    }

    @Test
    void testRemove() {
        String[] lst = new String[] {"qwerty", "asdfgh", "zxcvbn", "qwerty"};
        stringList.remove(3);
        Assertions.assertEquals(Arrays.toString(lst), Arrays.toString(stringList.toArray().toArray()));
    }

    @Test
    void contains() {
        boolean flag = stringList.contains("123456");
        Assertions.assertTrue(flag);
    }

    @Test
    void indexOf() {
        Integer index1 = 0;
        Integer index2 = stringList.indexOf("qwerty");
        Assertions.assertEquals(index1, index2);
    }

    @Test
    void lastIndexOf() {
        int index1 = 4;
        int index2 = stringList.lastIndexOf("qwerty");
        Assertions.assertEquals(index1, index2);
    }

    @Test
    void get() {
        String expected = "123456";
        String result = stringList.get(3);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testEquals() {
        String[] l = new String[listStringTest.toArray().length];
        for (int i = 0; i < listStringTest.size(); i++) {
            l[i] = listStringTest.get(i);
        }
        Assertions.assertEquals(Arrays.toString(l), Arrays.toString(stringList.toArray().toArray()));
    }

    @Test
    void size() {
        Assertions.assertEquals(5, stringList.size());
    }

    @Test
    void isEmpty() {
        StringList stringList1 = new StringListImpl();
        Assertions.assertTrue(stringList1.isEmpty());
    }

    @Test
    void clear() {
        stringList.clear();
        Assertions.assertTrue(stringList.isEmpty());
    }

    @Test
    void toArray() {
        Assertions.assertEquals(stringList.toArray(), listStringTest);
    }

    @Test
    void getList() {
        String[] list = new String[listStringTest.size()];
        for (int i = 0; i < listStringTest.size(); i++) {
            list[i] = listStringTest.get(i);
        }
        Assertions.assertEquals(Arrays.toString(list), Arrays.toString(stringList.toArray().toArray()));
    }
}