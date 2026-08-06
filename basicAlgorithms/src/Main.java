//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Integer[] integers = {1, 2, 3, 4, 5};
    Integer[] prevIntegers = Arrays.copyOfRange(integers, 0, 3);
    Integer[] nextIntegers = Arrays.copyOfRange(integers, 4, integers.length);
    Integer[] newIntegers = new Integer[integers.length + 1];
    System.out.println("Arrays.toString(prevIntegers) + \" \" + Arrays.toString(nextIntegers) = " + Arrays.toString(prevIntegers) + " " + Arrays.toString(nextIntegers));

    int[] result = new int[prevIntegers.length + nextIntegers.length];

// Копируем первый массив
    for (int i = 0; i < prevIntegers.length; i++) {
        result[i] = prevIntegers[i];
    }

// Копируем второй массив
    for (int i = 0; i < nextIntegers.length; i++) {
        result[prevIntegers.length + i] = nextIntegers[i];
    }
    System.out.println("result = " + Arrays.toString(result));
}
