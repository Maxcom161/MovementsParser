public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket();
        basket1.add("Milk", 40, 6, 0.5);
        basket1.add("Bread", 100, 3, 0.3);
        basket1.print("Корзина 1:");
        System.out.println("Общая стоимость товаров: " + basket1.getTotalPrice());
        System.out.println("Общий вес товаров в корзине: " + basket1.getTotalWeight() + " кг.");
        System.out.println();


        /*basket1.clear();
        System.out.println();
        basket1.print("Корзина 1:");
        System.out.println("Общая стоимость товаров: " + basket1.getTotalPrice());*/

    }
}
