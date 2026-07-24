public class Slizerin extends Student {
    private int cunning;
    private int determination;
    private int ambition;
    private int resourcefulness;
    private int thirstForPower;

    public Slizerin(String name, String surname, int transgressionDistance, int spellPower, int cunning, int determination, int ambition, int resourcefulness, int thirstForPower) {
        super(name, surname, transgressionDistance, spellPower);
        this.cunning = cunning;
        this.determination = determination;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.thirstForPower = thirstForPower;
    }

    public int getCunning() {
        return cunning;
    }

    public int getDetermination() {
        return determination;
    }

    public int getAmbition() {
        return ambition;
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public int getThirstForPower() {
        return thirstForPower;
    }

    @Override
    public String toString() {
        return "Slizerin{" +
                "Student=" + super.toString() +
                ", cunning=" + cunning +
                ", determination=" + determination +
                ", ambition=" + ambition +
                ", resourcefulness=" + resourcefulness +
                ", thirstForPower=" + thirstForPower +
                '}';
    }

    public static String compare(Slizerin student1, Slizerin student2) {
        int points1 = student1.getAmbition() + student1.getCunning() + student1.getDetermination() + student1.getResourcefulness() + student1.getThirstForPower();
        int points2 = student2.getAmbition() + student2.getCunning() + student2.getDetermination() + student2.getResourcefulness() + student2.getThirstForPower();
        Slizerin student = (points1 > points2) ? student1 : student2;
        return (student.getName() +" лучший Пуффендуец! (сравнивались " + student1.getName() + " и " + student2.getName() + ")");
    }
}
