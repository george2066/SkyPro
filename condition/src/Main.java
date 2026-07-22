//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int age = 17;
    if (age >= 18) {
        System.out.println("Вы совершеннолетний");
    } else {
        System.out.println("Вы несовершеннолетний");
    }

    int temp = 17;
    if (temp >= 5) {
        System.out.println("Сегодня тепло, можно идти без шапки");
    } else {
        System.out.println("На улице холодно, нужно надеть шапку");
    }

    int speed = 70;
    if (speed >= 60) {
        System.out.println("Если скорость " + speed + ", то придется заплатить штраф");
    } else {
        System.out.println("Если скорость " + speed + ", то можно ездить спокойно");
    }

    age = 45;
    if (age <= 2) {
        System.out.println("пора спать");
    } else if (age > 2 && age <= 6) {
        System.out.println("в детский сад");
    } else if (age > 6 && age <= 18) {
        System.out.println("нужно ходить в школу");
    } else if (age > 18 && age <= 24) {
        System.out.println("место в университете");
    } else if (age > 24 && age <= 60) {
        System.out.println("пора ходить на работу");
    } else if (age > 60) {
        System.out.println("можешь отдохнуть");
    }

    age = 45;
    boolean parents = true;
    if (age < 5) {
        System.out.println("он не может кататься на аттракционе");
    } else if (age >= 5 && age < 14) {
        if (parents) {
            System.out.println("он может кататься только в сопровождении взрослого.");
        } else {
            System.out.println("Если взрослого нет, то кататься нельзя.");
        }
    } else if (age >= 14) {
        System.out.println("он может кататься без сопровождения взрослого.");
    }
    // sedentary and standing
    byte places = 102;
    byte sedentary = 60;
    byte standing = (byte) (places - sedentary);

    int passengers = 70;

    if (passengers > places) {
        System.out.println("Мест нет");
    } else {
        if (passengers <= sedentary) {
            System.out.println("Все сядут");
        } else {
            System.out.println((passengers - 60) + " будут стоять");
        }
    }

    int one = 2876;
    int two = 1567;
    int three = 912;

    if (three > one && three > two) {
        System.out.println(three + " больше всех");
    } else {
        if (two > one) {
            System.out.println(two + " больше всех");
        } else {
            System.out.println(one + " больше всех");
        }
    }


    char color = 'g';
    switch (color) {
        case 'r':
            System.out.println("Красный! Ехать нельзя!");
            break;
        case 'y':
            System.out.println("Желтый. Внимание.");
            break;
        case 'g':
            System.out.println("Зеленый! Проезд разрешен.");
            break;
        case 'l':
            System.out.println("Поворот налево");
            break;
        default:
            System.out.println("Светофор сломался");
    }

    age = 6;
    switch (age) {
        case 18:
            System.out.println("С окончанием школы!");
            break;
        case 21:
            System.out.println("Теперь можно пить алкоголь");
            break;
        case 7:
            System.out.println("Иди в школу");
            break;
        default:
            System.out.println("Пока сказать нечего");
    }

    byte clientOS = 1;
    int clientDeviceYear = 2016;

    if (clientOS == 1 && clientDeviceYear > 2015) {
        System.out.println("Установите версию приложения для Android по ссылке");
    } else if (clientOS == 1 && clientDeviceYear <= 2015) {
        System.out.println("Установите облегченную версию приложения для Android по ссылке");
    } else if (clientDeviceYear <= 2015) {
        System.out.println("Установите облегченную версию приложения для iOS по ссылке");
    } else {
        System.out.println("Установите версию приложения для iOS по ссылке");
    }

    int year = 1600;

    if (year <= 1584) {
        System.out.println("Год должен быть больше, чем 1584");
    } else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        System.out.println(year + " год является високосным");
    } else {
        System.out.println(year + " год не является високосным");
    }

    byte deliveryDistance = 95;

    if (deliveryDistance <= 20) {
        System.out.println("Доставка займёт примерно сутки.");
    } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
        System.out.println("Даставка займёт примерно 2е суток.");
    } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
        System.out.println("Даставка займёт примерно 3е суток.");
    } else {
        System.out.println("Доставки нет.");
    }

    byte monthNumber = 12;

    switch (monthNumber) {
        case 1:
            System.out.println("Зима");
            break;
        case 2:
            System.out.println("Зима");
            break;
        case 3:
            System.out.println("Весна");
            break;
        case 4:
            System.out.println("Весна");
            break;
        case 5:
            System.out.println("Весна");
            break;
        case 6:
            System.out.println("Лето");
            break;
        case 7:
            System.out.println("Лето");
            break;
        case 8:
            System.out.println("Лето");
            break;
        case 9:
            System.out.println("Осень");
            break;
        case 10:
            System.out.println("Осень");
            break;
        case 11:
            System.out.println("Осень");
            break;
        case 12:
            System.out.println("Зима");
            break;
        default:
            System.out.println("Номер месяца должен быть в пределях от 1го до 12ти.");
    }
}