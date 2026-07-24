private int changeValue(int value) {
    value = 22;
    return value;
}

private Integer changeObject(Integer value) {
    value = 54;
    return value;
}

private Integer[] changeArray(Integer[] array) {
    Integer o = 3;
    for (int i = 0; i < array.length; i++) {
        array[i] = o;
        o++;
    }
    return array;
}

private void changePerson(Person person) {
    person.setSurname("Trubeckoy");
}

private void changeNameAndSurnameOfPerson(Person person) {
    person.setName("Gosha");
    person.setSurname("Rodionov");
}

void main() {
    int value = 33;
    System.out.println(value);
    System.out.println(changeValue(value)); // Переменная сама не изменится, потому что метод в качестве аргумента берёт копию и возвращает изменённую копию (вспомните об области видимости)
    System.out.println(value);

    System.out.println("____________________________________________");

    Integer integer = 32;
    System.out.println(integer);
    System.out.println(changeObject(integer));
    System.out.println(integer);

    System.out.println("____________________________________________");

    Integer[] array = {1, 2};
    System.out.println(Arrays.toString(array));
    System.out.println(Arrays.toString(changeArray(array)));
    System.out.println(Arrays.toString(array));

    System.out.println("____________________________________________");

    Person person = new Person("Ilya", "Lagutenko");
    System.out.println(person);
    changePerson(person);
    System.out.println(person);
    changeNameAndSurnameOfPerson(person);
    System.out.println(person);
}
