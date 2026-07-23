void main() {
    int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    float[] floats = {1.57f, 7.654f, 9.986f};
    char[] characters = {'w', 'f', 'j'};
    for (int i = 0; i < integers.length; i++) {
        if (i == (integers.length - 1)) {
            System.out.print(integers[i]);
            break;
        }
        System.out.print(integers[i] + ", ");
    }
    System.out.println();
    for (int i = integers.length - 1; i >= 0; i--) {
        if (i == 0) {
            System.out.print(integers[i]);
            break;
        }
        System.out.print(integers[i] + ", ");
    }
    System.out.println();
    String string = "";
    for (int i = 0; i < integers.length; i++) {
        if (integers[i] % 2 != 0) {
            integers[i] += 1;
            string += integers[i] + ", ";
            continue;
        }
        if (i == (integers.length - 1)) {
            string += integers[i];
            break;
        }
        string += integers[i] + ", ";
    }
    System.out.println(string);
    //int[] arr = new int[10];
    //Arrays.fill(arr, 1);
    // Первым параметром передаем имя массива
    // Вторым — значение, которым его нужно заполнить

    int[] salaries = {100000, 120000, 150000, 90000, 75000};
    int debit = 0;
    int minSalary = salaries[0];
    int maxSalary = salaries[0];
    for (int salary : salaries) {
        debit += salary;
        if (salary > maxSalary) {
            maxSalary = salary;
        } else if (salary < minSalary){
            minSalary = salary;
        }
    }
    float avgSalaries = (float) debit / salaries.length;

    System.out.println("Минимальная сумма трат за неделю составила " + minSalary + " рублей. Максимальная сумма трат за неделю составила " + maxSalary + " рублей");
    System.out.println("Сумма трат за месяц составила " + debit + " рублей");
    System.out.println("Средняя сумма трат за месяц составила " + avgSalaries + " рублей");

    char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

    for (int i = reverseFullName.length - 1; i >= 0; i--) {
        System.out.print(reverseFullName[i]);
    }
}
