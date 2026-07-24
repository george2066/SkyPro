void main() {
    byte min = 0;
    byte max = 100;
    int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
    int randomNum1 = ThreadLocalRandom.current().nextInt(min, max + 1);
    int randomNum2 = ThreadLocalRandom.current().nextInt(min, max + 1);
    int randomNum3 = ThreadLocalRandom.current().nextInt(min, max + 1);


    Griffindor hermione = new Griffindor("Hermione", "Granger",  1,  randomNum,  4,  4,  4);
    Griffindor harry = new Griffindor("Harry", "Potter", 2,  randomNum1,  randomNum2,  4,  76);
    Griffindor ron = new Griffindor("Ron", "Weasley", 3, 5,  randomNum,  44,  16);

    Slizerin draco = new Slizerin("Draco", "Malfoy", 4,  randomNum3, 40, 36, 100, 23, 45);
    Slizerin graham = new Slizerin("Graham", "Montague", 4,  27, randomNum, 36, 18, 23, 55);
    Slizerin gregory = new Slizerin("Gregory", "Goyle", 4,  57, 10, 46, 10, 23, 67);

    Kogtevran cho = new Kogtevran("Cho", "Chang", 6, 56, 3, 2, 1, 4);
    Kogtevran padma = new Kogtevran("Padma", "Patil", 6, 56, 3, 2, 1, 4);
    Kogtevran marcus = new Kogtevran("Marcus", "Belby", 6, 56, 3, 2, 1, 4);

    Puffenduy zacharias = new Puffenduy("Zacharias", "Smith", 95, 78, 23, 76, 45);
    Puffenduy cedric = new Puffenduy("Cedric", "Diggory", 95, 78, 23, 76, 45);
    Puffenduy justin = new Puffenduy("Justin", "Finch-Fletchley", 95, 78, 23, 76, 45);
    System.out.println(cho);
    System.out.println(Puffenduy.compare(zacharias, cedric));
    System.out.println(Kogtevran.compare(cho, padma));
    System.out.println(Slizerin.compare(draco, graham));
    System.out.println(Griffindor.compare(harry, ron));
    System.out.println(Student.compare(marcus, harry));
}