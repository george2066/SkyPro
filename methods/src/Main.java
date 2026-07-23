

class HomeWork {
    private String os(int clientOS, int clientDeviceYear) {
        String string = "";
        if (clientOS == 1 && clientDeviceYear > 2015) {
            string = "Установите версию приложения для Android по ссылке";
        } else if (clientOS == 1 && clientDeviceYear <= 2015) {
            string = "Установите облегченную версию приложения для Android по ссылке";
        } else if (clientDeviceYear <= 2015) {
            string = "Установите облегченную версию приложения для iOS по ссылке";
        } else {
            string = "Установите версию приложения для iOS по ссылке";
        }
        return string;
    }

    private String isLeapYear(int year) {
        String string = "";
        if (year <= 1584) {
            string = "Год должен быть больше, чем 1584";
        } else if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            string = year + " год является високосным";
        } else {
            string = year + " год не является високосным";
        }
        return string;
    }

    private String calculationDaysDelivery(int deliveryDistance) {
        String string = "";
        if (deliveryDistance <= 20) {
            string = "Доставка займёт примерно сутки.";
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            string = "Даставка займёт примерно 2е суток.";
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            string = "Даставка займёт примерно 3е суток.";
        } else {
            string = "Доставки нет.";
        }
        return string;
    }

    void main() {
        byte clientOS = 1;
        int clientDeviceYear = 2016;
        String stringOS = os(clientOS, clientDeviceYear);

        int year = 1600;
        String stringLeapYear = isLeapYear(year);

        byte deliveryDistance = 95;

        String stringDaysDelivery = calculationDaysDelivery(deliveryDistance);

        System.out.println(stringOS);
        System.out.println(stringLeapYear);
        System.out.println(stringDaysDelivery);
    }
}