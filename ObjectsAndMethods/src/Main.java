public class Main {

    public static void main(String[] args) {
        Basket basket1 = new Basket();
        basket1.add("Water", 100, 2, 0.5);
        basket1.add("Meat", 700, 1, 0.3);
        basket1.print("Корзина 1:");
        System.out.println("Общая стоимость товаров: " + basket1.getTotalPrice());
        System.out.println("Общий вес товаров в корзине: " + basket1.getTotalWeight() + " кг.");
        System.out.println("Общее количество товаров в корзине: " + basket1.getAmountProduct() + " шт.");
        System.out.println();

        Basket basket2 = new Basket();
        basket2.add("Milk", 40, 6, 0.5);
        basket2.add("Bread", 100, 3, 0.3);
        basket2.print("Корзина 2:");
        System.out.println("Общая стоимость товаров: " + basket2.getTotalPrice());
        System.out.println("Общий вес товаров в корзине: " + basket2.getTotalWeight() + " кг.");
        System.out.println("Общее количество товаров в корзине: " + basket2.getAmountProduct() + " шт.");
        System.out.println();

        Basket basket3 = new Basket();
        basket3.add("Sweets", 300, 3, 0.5);
        basket3.add("Eggs", 8, 20, 0.3);
        basket3.print("Корзина 3:");
        System.out.println("Общая стоимость товаров: " + basket3.getTotalPrice());
        System.out.println("Общий вес товаров в корзине: " + basket3.getTotalWeight() + " кг.");
        System.out.println("Общее количество товаров в корзине: " + basket3.getAmountProduct() + " шт.");
        System.out.println();


        System.out.println("Общее количество проданных корзин: "+ Basket.getCount());
        System.out.println("Общая стоимость проданных товаров: "+ Basket.getAllTotalPrice());
        System.out.println("Общее количество проданных товаров: "+ Basket.getAllAmountProduct());
        System.out.println("Средняя стоимость 1 проданного (за всю историю магазина) товара: "+ Basket.getAveragePrice() + " руб.");
        System.out.println("Средняя цена чека:  "+ Basket.getAverageCheck() + " руб.");



        /*basket1.clear();
        System.out.println();
        basket1.print("Корзина 1:");
        System.out.println("Общая стоимость товаров: " + basket1.getTotalPrice());*/

    }
}
