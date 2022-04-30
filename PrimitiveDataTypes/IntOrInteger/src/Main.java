public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        System.out.println(container.getCount());
        container.addCount(5672);
        System.out.println(container.getCount());
        container.addCount(1000);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        for (int i = 0; i <= 65535; i++) {
            char lettersRussian = (char) i;
            if (lettersRussian >= 'а' && lettersRussian <= 'я')
                System.out.println(lettersRussian + "-" + i);
            else if (lettersRussian >= 'А' && lettersRussian <= 'Я')
                System.out.println(lettersRussian + "-" + i);
            else if (lettersRussian == 'ё' || lettersRussian == 'Ё')
                System.out.println(lettersRussian + "-" + i);

        }

    }

}
