public class IndividualEntrepreneurClient extends Client {

    private final String condition = "Если вносится сумма меньше 1000 - комиссия составит 1%," +
            " если больше 1000 - 0,5%" + "\n" +
            "Списание происходит без комиссии";

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amount) {
        if (amount < 1000 && amount > 0) {
            amountOfMoney += amount - (amount * 0.01);
        } else if (amount >= 1000) {
            amountOfMoney += amount - (amount * 0.005);
        }
    }

    @Override
    public void take(double amount) {
        super.take(amount);
    }

    @Override
    public String getName() {
        return "Индивидуальный предприниматель";
    }

    @Override
    public String info() {
        return getName() + "\n" + condition + "\n" + "Баланс счета - " + getAmount() + "\n";
    }
}
