void main() {
    for (int i = 1; i <= 10; i++) {
        System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    for (int i = 10; i > 0; i--) {
        System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    for (int i = 0; i < 17; i = i + 2) {
        System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    for (int i = 10; i >= -10; i--) {
        System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    int currentYear = 2096;
    for (int i = 1904; i < currentYear; i = i + 4) {
        System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    for (int i = 7; i < 100; i = i + 7) {
        System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    for (int i = 1; i < 1024; i = i * 2) {
        System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    int total = 0;
    int monthNumber = 1;
    while (total <= 2459000) {
        total += 15000;
        System.out.println("Месяц " + monthNumber + ", сумма накоплений равна " + total + " рублей");
        monthNumber++;
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    for (int i = 0; i < 11; i++) {
        System.out.println("2*" + i + "="+ (2 * i));
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    int i = 1;
    while (i <= 10) {
        System.out.print(i + " ");
        i++;
    }
    System.out.println();
    for (int j = 10; j > 0; j--) {
        System.out.print(j + " ");
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    byte mortality = 8;
    int birth = 17;
    int urban = 12_000_000;
    int birthYear = 0;
    int mortalityYear = 0;
    for (int j = 1; j < 11; j++) {
        System.out.println("Год " + j + ", численность населения составляет " + urban);
        birthYear = birth * (urban / 1000);
        mortalityYear = mortality * (urban / 1000);
        urban -= mortalityYear;
        urban += birthYear;
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    total = 15_000;
    monthNumber = 1;
    while (monthNumber <= (12 * 9)) {
        total += (total / 100 * 7);
        monthNumber++;
        if (monthNumber % 6 == 0) {
            System.out.println("Месяц " + monthNumber + ", сумма на счёте " + total);
        }
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    byte friday = 1;
    while (friday <= 31) {
        System.out.println("Сегодня " + friday + ". Нужно подготовить отчёт.");
        friday += 7;
    }
    System.out.println();
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    currentYear = 2026;
    int futureYear = currentYear + 100;
    int oldYear = currentYear - 200;
    int firstYear = 79;
    for (int j = oldYear; j < futureYear; j++) {
        if (j % 79 == 0) {
            firstYear = j;
            break;
        }
    }
    while (firstYear < futureYear) {
        System.out.println(firstYear);
        firstYear += 79;
    }
}
