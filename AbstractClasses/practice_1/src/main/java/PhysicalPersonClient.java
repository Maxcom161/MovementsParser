public class PhysicalPersonClient extends Client {

    private final String condition = "Пополнение и списание происходит без комиссии";

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amount) {
        super.put(amount);
    }

    @Override
    public void take(double amount) {
        super.take(amount);
    }

    @Override
    public String getName() {
        return "Физическое лицо";
    }

    @Override
    public String info() {
        return getName() + "\n" + condition + "\n" + "Баланс счета - " + getAmount() + "\n";
    }


}
