public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private int amountProduct = 0;


    private static int allAmountProduct = 0;
    private static int allTotalPrice = 0;
    private static double averagePrice = 0;
    private static double averageCheck = 0;




    public Basket() {

        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items +"\n" + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }
    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }



    public static void increaseAllAmountProduct(int count) {
        Basket.allAmountProduct = Basket.allAmountProduct + count;
    }
    public static int getAllAmountProduct() {
        return allAmountProduct;
    }
    public static void increaseAllTotalPrice (int price, int count) {
        Basket.allTotalPrice = Basket.allTotalPrice + price * count;
    }
    public static int getAllTotalPrice() { return allTotalPrice; }

    public static void calculateAveragePrice() {
        Basket.averagePrice = Basket.allTotalPrice / Basket.allAmountProduct;
      }
    public static double getAveragePrice() {
        return averagePrice;
    }
    public static void calculateAverageCheck() {
        Basket.averageCheck = Basket.getAllTotalPrice() / Basket.getCount();
    }
    public static double getAverageCheck() {
        return averageCheck;
    }



    public void add(String name, int price) {
        add(name, price, 1, 0.0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + weight + " кг. - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + count * weight;
        amountProduct = amountProduct + count;
        increaseAllAmountProduct(count);
        increaseAllTotalPrice(count, price);
        calculateAveragePrice();
        calculateAverageCheck();

    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public int getAmountProduct() {
        return amountProduct;
    }

    public double getTotalWeight() {
        return totalWeight; }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
