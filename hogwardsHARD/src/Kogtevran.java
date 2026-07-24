public class Kogtevran extends Student {
    private int smart;
    private int wise;
    private int witty;
    private int creativity;

    public Kogtevran(String name, String surname, int transgressionDistance, int spellPower, int smart, int wise, int witty, int creativity) {
        super(name, surname, transgressionDistance, spellPower);
        this.smart = smart;
        this.wise = wise;
        this.witty = witty;
        this.creativity = creativity;
    }

    public int getSmart() {
        return smart;
    }

    public int getWise() {
        return wise;
    }

    public int getWitty() {
        return witty;
    }

    public int getCreativity() {
        return creativity;
    }

    @Override
    public String toString() {
        return "Kogtevran{" +
                super.toString() +
                ", smart=" + smart +
                ", wise=" + wise +
                ", witty=" + witty +
                ", creativity=" + creativity +
                '}';
    }

    public static String compare(Kogtevran student1, Kogtevran student2) {
        int points1 = student1.getCreativity() + student1.getSmart() + student1.getWise() + student1.getWitty();
        int points2 = student2.getCreativity() + student2.getSmart() + student2.getWise() + student2.getWitty();
        Kogtevran student = (points1 > points2) ? student1 : student2;
        return (student.getName() +" лучший Когтевранец! (сравнивались " + student1.getName() + " и " + student2.getName() + ")");
    }
}
