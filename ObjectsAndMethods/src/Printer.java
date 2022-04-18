public class Printer {

    private static String queue = "";
    private static int pendingPagesCount = 0;
    private static int countPrintedPages = 0;

    public static void main(String[] args) {
        append("Введение");
        append("Курсовая работа", "Титульный лист");
        append("История Царской России 1701-1917 годы", "Содержание работы", 16);
        print("Документы ожидающие печать: ");
    }

    public static void append(String content) {
        append(content, "", 1);
    }

    public static void append(String content, String name) {
        append(content, name, 1);
    }

    public static void append(String content, String name, int page) {
        queue = queue + "\n" + content + " " + name + " " + "Количество страниц: " + page;
        pendingPagesCount = pendingPagesCount + page;
    }

    public static int getPendingPagesCount() {
        return pendingPagesCount;
    }
    public static int getCountPrintedPages() {
        return countPrintedPages;
    }

    public static void clear() {

        queue = "";
        pendingPagesCount = 0;

    }

    public static void print(String loading) {
        System.out.println(loading);
        if(queue.isEmpty()) {
            System.out.println("Отсутствуют документы в очереди на печать!!!");
        } else {
            System.out.println(queue);
            countPrintedPages=countPrintedPages + pendingPagesCount;
            System.out.println("Общее количество страниц ожидающих печать: " + getPendingPagesCount());
            System.out.println("Количество напечатанных страниц: " + countPrintedPages);
            clear();
        }
    }
}
