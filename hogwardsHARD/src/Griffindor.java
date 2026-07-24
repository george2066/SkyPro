public class Griffindor extends Student {
    private int nobility;
    private int honor;
    private int bravery;

    public Griffindor(String name, String surname, int transgressionDistance, int spellPower, int nobility, int honor, int bravery) {
        super(name, surname, transgressionDistance, spellPower);
        this.nobility = nobility;
        this.honor = honor;
        this.bravery = bravery;
    }

    public int getNobility() {
        return nobility;
    }

    public int getHonor() {
        return honor;
    }

    public int getBravery() {
        return bravery;
    }

    @Override
    public String toString() {
        return "Griffindor{" +
                super.toString() +
                ", nobility=" + nobility +
                ", honor=" + honor +
                ", bravery=" + bravery +
                '}';
    }

    public static String compare(Griffindor student1, Griffindor student2) {
        int points1 = student1.getBravery() + student1.getHonor() + student1.getNobility();
        int points2 = student2.getBravery() + student2.getHonor() + student2.getNobility();
        Griffindor student = (points1 > points2) ? student1 : student2;
        return (student.getName() +" лучший Гриффиндорец! (сравнивались " + student1.getName() + " и " + student2.getName() + ")");
    }
}