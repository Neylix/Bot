public abstract class Strategies {
    private boolean position;
    private double startBalance, balance, pourcentage;

    public Strategies() {
        pourcentage = 0.1;
    }

    public abstract void treatment(String html);
}
