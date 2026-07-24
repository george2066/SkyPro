public class Puffenduy extends Student {
    private int hardworking;
    private int loyal;
    private int honest;

    public Puffenduy(String name, String surname, int transgressionDistance, int spellPower, int hardworking, int loyal, int honest) {
        super(name, surname, transgressionDistance, spellPower);
        this.hardworking = hardworking;
        this.loyal = loyal;
        this.honest = honest;
    }

    public int getHardworking() {
        return hardworking;
    }

    public int getLoyal() {
        return loyal;
    }

    public int getHonest() {
        return honest;
    }

    @Override
    public String toString() {
        return "Kogtevran{" +
                super.toString() +
                ", hardworking=" + hardworking +
                ", loyal=" + loyal +
                ", honest=" + honest +
                '}';
    }

    public static String compare(Puffenduy student1, Puffenduy student2) {
        int points1 = student1.getHardworking() + student1.getHonest() + student1.getLoyal();
        int points2 = student2.getHardworking() + student2.getHonest() + student2.getLoyal();
        Puffenduy student = (points1 > points2) ? student1 : student2;
        return (student.getName() +" лучший Пуффендуец! (сравнивались " + student1.getName() + " и " + student2.getName() + ")");
    }
}
