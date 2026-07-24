public class Student {
    private String name;
    private String surname;
    private int transgressionDistance;
    private int spellPower;

    public Student(String name, String surname, int transgressionDistance, int spellPower) {
        this.name = name;
        this.surname = surname;
        this.transgressionDistance = transgressionDistance;
        this.spellPower = spellPower;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getTransgressionDistance() {
        return transgressionDistance;
    }

    public int getSpellPower() {
        return spellPower;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", transgressionDistance=" + transgressionDistance +
                ", spellPower=" + spellPower +
                '}';
    }

    public static String compare(Student student1, Student student2) {
        String betterSpellPower = (
                student1.getSpellPower() > student2.getSpellPower()
        ) ? (
                student1.getName() + " " + student1.surname + " обладает бОльшей мощностью магии, чем " + student2.getName() + " " + student2.getSurname()
        ) : (
                student2.getName() + " " + student2.surname + " обладает бОльшей мощностью магии, чем " + student1.getName() + " " + student1.getSurname()
        );
        String betterTransgression = (
                student1.getTransgressionDistance() > student2.getTransgressionDistance()
        ) ? (
                student1.getName() + " " + student1.surname + " обладает бОльшей мощностью трансгрессии, чем " + student2.getName() + " " + student2.getSurname()
        ) : (
                student2.getName() + " " + student2.surname + " обладает бОльшей мощностью трансгрессии, чем " + student1.getName() + " " + student1.getSurname()
        );
        String finalString = betterSpellPower + "\n" + betterTransgression;
        return finalString;

    }
}
