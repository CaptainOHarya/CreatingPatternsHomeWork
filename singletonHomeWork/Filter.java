package creatingpatterns.singletonHomeWork;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    public int numberReturn;

    public Filter() {
    }


    public int getNumberReturn() {
        return numberReturn;
    }

    public List<Integer> filterOut(List<Integer> list, int thresholdFilter, int i) {
        List<Integer> afterFilter = new ArrayList<>();
        Logger.getLogger().addLogInfo("Запускаем фильтрацию");
        Logger.getLogger().showLog(i);
        i++;
        for (Integer list1 : list) {
            if (list1 < thresholdFilter) {
                Logger.getLogger().addLogInfo("Элемент " + list1 + " не проходит");
                Logger.getLogger().showLog(i);
                i++;
            } else {
                Logger.getLogger().addLogInfo("Элемент " + list1 + " проходит");
                Logger.getLogger().showLog(i);
                i++;
                afterFilter.add(list1);

            }
            numberReturn = i;
        }


        return afterFilter;
    }
}

