public class PhysicalPersonClient extends Client {

    private final String condition = "Пополнение и списание происходит без комиссии";

    @Override
    public String getName() {
        return "Физическое лицо";
    }

    @Override
    public String info() {
        return getName() + "\n" + condition + "\n" + "Баланс счета - " + getAmount() + "\n";
    }


}
