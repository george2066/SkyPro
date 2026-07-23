void main() {
    String firstName = new String();
    String middleName = new String();
    String lastName = new String();
    String fullName = new String();
    String fio = "Ivanov Ivan Ivanovich";
    String[] fioArray = fio.split(" ");
    firstName += fioArray[0];
    middleName += fioArray[1];
    lastName += fioArray[2];
    fullName += firstName + " " + middleName + " " + lastName;
    System.out.println("Ф. И. О. сотрудника — " + fullName);
    String fullNameUpperCase = fullName.toUpperCase(Locale.ROOT);
    System.out.println(fullNameUpperCase);

    String noValidName = "Семёнов Семён Семёнович";
    String validName = noValidName.replace("ё", "е");
    System.out.println(validName);
}
