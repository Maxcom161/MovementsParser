public class CompanyClient extends Client {

    private final String condition = "Пополнение происходит без комиссии, списание производится с комиссией 1%";

    @Override
    public void take(double amount) {
        double commission = 0.01;
        if (amountOfMoney >= amount + amount * commission) {
            amountOfMoney -= amount + amount * commission;
        }
    }

    @Override
    public String getName() {
        return "Юридическое лицо";
    }

    @Override
    public String info() {
        return getName() + "\n" + condition + "\n" + "Баланс счета - " + getAmount() + "\n";
    }
}
