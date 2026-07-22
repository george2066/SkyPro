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
}
