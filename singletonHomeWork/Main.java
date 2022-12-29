package creatingpatterns.singletonHomeWork;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // Переменная размера списка
    static int length;
    // Переменная верхей границы списка
    static int upperLimit;
    // Число для фильтрации списка
    static int thresholdFilter;
    // порядковый номер выводимого сообщения
    static int i;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Filter filter = new Filter();

        // наш исходный список случайных чисел
        List<Integer> filterBefore = new ArrayList<>();

        i = 1;
        Logger.getLogger().addLogInfo("Доброго времени суток!!! Это программа Логгер");
        Logger.getLogger().showLog(i);
        i += i;


        try {
            while (true) {
                Logger.getLogger().addLogInfo("Введите количество элементов(размер списка): ");
                Logger.getLogger().showLog(i);
                length = scanner.nextInt();
                i++;

                Logger.getLogger().addLogInfo("Введите верхнюю границу значений элементов в списке:");
                Logger.getLogger().showLog(i);
                upperLimit = scanner.nextInt();
                i++;

                if (length <= 0 || upperLimit <= 0) {
                    Logger.getLogger().addLogInfo("Числа должны быть целыми и положительными");
                    Logger.getLogger().showLog(i);
                    i++;
                } else break;

            }

        } catch (InputMismatchException err) {
            System.err.println("Должно быть число и оно должно быть целым");

        }

// Заполняем наш списко случайными числами
        for (int j = 1; j <= length; j++) {
            filterBefore.add(random.nextInt(upperLimit));

        }
        Logger.getLogger().addLogInfo("Вот случайный список " + filterBefore);
        Logger.getLogger().showLog(i);
        i++;

        // Ввод данных о фильтрации
        try {
            while (true) {
                Logger.getLogger().addLogInfo("Введите порог для фильтра:");
                Logger.getLogger().showLog(i);
                thresholdFilter = scanner.nextInt();
                i++;

                if (thresholdFilter < 0 || thresholdFilter > upperLimit) {
                    Logger.getLogger().addLogInfo("Числа должны быть между нулём и верхней границей значений");
                    Logger.getLogger().showLog(i);
                    i++;
                } else break;

            }


        } catch (InputMismatchException err) {
            System.err.println("Должно быть число и оно должно быть целым");

        }

        // Запускаем фильтрацию
        Logger.getLogger().addLogInfo("Отфильтрованный список " + filter.filterOut(filterBefore, thresholdFilter, i));
        // Возвратим порядковый номер выводимого логгером сообщения
        i = filter.getNumberReturn();
        Logger.getLogger().showLog(i);
        i++;
        Logger.getLogger().addLogInfo("На этом всё! Программа Логгер завершает свою работу!!! ");
        Logger.getLogger().showLog(i);


    }

}


