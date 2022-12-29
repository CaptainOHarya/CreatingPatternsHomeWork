package creatingpatterns.singletonHomeWork;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger;
    // Для красивого вывода времени
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static String logFile = "";

    private Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    // метод добавления нашего лога
    public void addLogInfo(String logInfo) {
        logFile += logInfo;
    }

    // Метод красивого вывода времени
    private static String getTimeView(LocalDateTime time) {
        return time.format(DATE_TIME_FORMATTER);
    }

    // метод для отображения лога
    public void showLog(int i) {
        // System.out.println("[" + getTimeView(LocalDateTime.now()) + " " + i + "] " + logFile);
        System.out.println(i + ". " + logFile + " - [" + getTimeView(LocalDateTime.now()) + "]");
        logFile = "";

    }
}


