//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int i = 9;
    byte b = 9;
    short s = 9;
    long l = 9;
    float f = 9.0f;
    double d = 9.0;
    System.out.println("Значение переменной " + i + " с типом " + ((Object) i).getClass().getSimpleName() + " равно " + i);
    System.out.println("Значение переменной " + b + " с типом " + ((Object) b).getClass().getSimpleName() + " равно " + b);
    System.out.println("Значение переменной " + s + " с типом " + ((Object) s).getClass().getSimpleName() + " равно " + s);
    System.out.println("Значение переменной " + l + " с типом " + ((Object) l).getClass().getSimpleName() + " равно " + l);
    System.out.println("Значение переменной " + f + " с типом " + ((Object) f).getClass().getSimpleName() + " равно " + f);
    System.out.println("Значение переменной " + d + " с типом " + ((Object) d).getClass().getSimpleName() + " равно " + d);
    System.out.println();
    d = 27.12f;
    l = 987678965549L;
    f = 2.786f;
    s = 569;
    s = -159;
    s = 27897;
    b = 67;

    short paper = 480;
    byte children = 23 + 27 + 30;
    System.out.println("На каждого ученика рассчитано " + (paper / children) + " листов бумаги");
    System.out.println();

    byte bootles = 16;
    short moment1 = (short) ((bootles / 2) * 20);
    short moment2 = (short) ((bootles / 2) * (24 * 60));
    int moment3 = (int) (moment2 * 3);
    short moment4 = (short) (moment2 * 31);
    short moment45 = (short) (moment2 * 30);
    System.out.println("За 20 минут машина произвела " + moment1 + " штук бутылок");
    System.out.println("За сутки машина произвела " + moment2 + " штук бутылок");
    System.out.println("За 3е суток машина произвела " + moment3 + " штук бутылок");
    System.out.println("За високосный месяц машина произвела " + moment4 + " штук бутылок");
    System.out.println("За за невисокосный месяц машина произвела " + moment45 + " штук бутылок");
    System.out.println();

    byte cans = 120;
    byte count = (byte) (cans / 6);
    byte whileColor = (byte) (count * 2);
    byte brownColor = (byte) (count * 4);
    System.out.println("В школе, где " + count + " классов, нужно " + whileColor + " банок белой краски и " + brownColor + " банок коричневой краски");
    System.out.println();

    float gramms = (float) (5 * 80 + 105 * 2 + 100 * 2 + 4 * 70) / 1000;
    System.out.println(gramms);
    System.out.println();

    float countDays250 = (float) (7 / 0.25);
    float countDays500 = (float) (7 / 0.5);
    System.out.println(countDays250);
    System.out.println(countDays500);
    System.out.println((countDays500 + countDays250) / 2);
    System.out.println();

    int masha = 67760;
    int denis = 83690;
    int chris = 76230;
    float mashaNewSalary = masha + ((float) masha / 100 * 10);
    float denisNewSalary = denis + ((float) denis / 100 * 10);
    float chrisNewSalary = chris + ((float) chris / 100 * 10);
    int incomeOldMasha = masha * 12;
    int incomeOldDenis = denis * 12;
    int incomeOldChris = chris * 12;
    float incomeNewMasha = mashaNewSalary * 12;
    float incomeNewDenis = denisNewSalary * 12;
    float incomeNewChris = chrisNewSalary * 12;

    System.out.println("Маша теперь получает " + mashaNewSalary + " рублей. Годовой доход вырос на " + (incomeNewMasha - incomeOldMasha) + " рублей");
    System.out.println("Денис теперь получает " + denisNewSalary + " рублей. Годовой доход вырос на " + (incomeNewDenis - incomeOldDenis) + " рублей");
    System.out.println("Кристинатеперь получает " + chrisNewSalary + " рублей. Годовой доход вырос на " + (incomeNewChris - incomeOldChris) + " рублей");
}