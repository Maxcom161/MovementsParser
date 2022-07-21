public abstract class Client {

    protected double amountOfMoney;

    public double getAmount() {
        return amountOfMoney;
    }

    public void put(double amount) {
        if (amount > 0) {
            amountOfMoney += amount;
        }
    }

    public void take(double amount) {
        if (amountOfMoney > 0 && amount > 0 && amount <= amountOfMoney) {
            amountOfMoney -= amount;
        }
    }

    public abstract String getName();

    public abstract String info();

}
