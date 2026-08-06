import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringListImpl implements StringList {
    String[] list = new String[0];
    @Override
    public void add(String item) {
        String[] newList = new String[this.list.length + 1];
        for (int i = 0; i < this.list.length; i++) {
            newList[i] = this.list[i];
        }
        newList[this.list.length] = item;
        this.list = newList;
    }

    @Override
    public void add(int index, String item) {
        String[] prevStrings = Arrays.copyOfRange(this.list, 0, index);
        String[] nextStrings = Arrays.copyOfRange(this.list, index, this.list.length);
        String[] newList = new String[this.list.length + 1];
        int n = 0;
        for (int i = 0; i < prevStrings.length; i++) {
            newList[i] = prevStrings[i];
            n = i;
        }
        newList[n + 1] = item;
        n += 2;
        int k = 0;
        for (int i = n; i < newList.length; i++) {
            newList[i] = nextStrings[k];
            k += 1;
        }
        this.list = newList;
    }

    @Override
    public void set(int index, String item) {
        this.list[index] = item;
    }

    @Override
    public void remove(String item) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].equals(item)) {
                index = i;
                break;
            }
        }
        String[] prevStrings = Arrays.copyOfRange(this.list, 0, index);
        String[] nextStrings = Arrays.copyOfRange(this.list, index + 1, this.list.length);
        String[] result = new String[prevStrings.length + nextStrings.length];
        for (int i = 0; i < prevStrings.length; i++) {
            result[i] = prevStrings[i];
        }
        for (int i = 0; i < nextStrings.length; i++) {
            result[prevStrings.length + i] = nextStrings[i];
        }
        this.list = result;
    }

    @Override
    public void remove(int index) {
        String[] prevStrings = Arrays.copyOfRange(this.list, 0, index);
        String[] nextStrings = Arrays.copyOfRange(this.list, index + 1, this.list.length);
        String[] result = new String[prevStrings.length + nextStrings.length];
        for (int i = 0; i < prevStrings.length; i++) {
            result[i] = prevStrings[i];
        }
        for (int i = 0; i < nextStrings.length; i++) {
            result[prevStrings.length + i] = nextStrings[i];
        }
        this.list = result;
    }

    @Override
    public boolean contains(String item) {
        int i = 0;
        while (i < this.list.length) {
            if (this.list[i].equals(item)) {
                return true;
            }
            i += 1;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = this.list.length - 1; i > 0; i--) {
            if (this.list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        return this.list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Objects.equals(this.list, otherList.getList());
    }

    @Override
    public int size() {
        return this.list.length;
    }

    @Override
    public boolean isEmpty() {
        return this.list.length == 0;
    }

    @Override
    public void clear() {
        this.list = new String[0];
    }

    @Override
    public List<String> toArray() {
        return Arrays.asList(this.list);
    }

    @Override
    public String[] getList() {
        return this.list;
    }
}
