public abstract class Transport {
    private String modelName;
    private int wheelsCount;

    public Transport(String modelName, int wheelsCount) {
        this.modelName = modelName;
        this.wheelsCount = wheelsCount;
    }

    public String getModelName() {
        return modelName;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void updateTyre() {
        System.out.println("Метод не переопределён");
    }
    public void checkEngine() {
        System.out.println("Метот не переопределён");
    }
    public void checkTrailer() {
        System.out.println("Метод не переопределён");
    }
}
