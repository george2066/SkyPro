//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    var dog = 8.0;
    var cat = 3.6;
    var paper = 763789;
    System.out.println(dog);
    System.out.println(cat);
    System.out.println(paper);
    System.out.println();
    dog += 4;
    cat += 4;
    paper += 4;
    System.out.println(dog);
    System.out.println(cat);
    System.out.println(paper);
    System.out.println();
    dog -= 3.5;
    cat -= 1.6;
    paper -= 7639;
    System.out.println(dog);
    System.out.println(cat);
    System.out.println(paper);
    System.out.println();
    var friend = 19;
    System.out.println(friend);
    friend = friend + 2;
    System.out.println(friend);
    friend = friend / 7;
    System.out.println(friend);
    System.out.println();
    var frog = 3.5;
    System.out.println(frog);
    frog *= 10;
    System.out.println(frog);
    frog /= 3.5;
    System.out.println(frog);
    frog += 4;
    System.out.println(frog);
    System.out.println();
    var weight1Fighter = 78.2;
    var weight2Fighter = 82.7;
    System.out.println(weight1Fighter + weight2Fighter);
    var diff = weight2Fighter - weight1Fighter;
    System.out.println(diff);
    System.out.println();

    var countHour = 680;
    var hour = 8;
    var employees =  countHour / hour;
    System.out.println("Всего работников в компании — " + employees + " человек");
    employees += 94;
    countHour = countHour / employees;
    System.out.println("Если в компании работает " + employees + " человек, то всего " + countHour + " часов работы может быть поделено между сотрудниками");
}
