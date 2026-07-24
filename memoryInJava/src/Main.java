private int changeValue(int value) {
    value += 33;
    return value;
}

void main() {
    int value = 33;
    System.out.println(changeValue(value));
    System.out.println(value);
}
