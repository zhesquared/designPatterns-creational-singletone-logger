import java.text.SimpleDateFormat;

public class Logger {
    protected int num = 1;
    private final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private static Logger logger; //ссылка на единственный объект этого класса

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + DATE_FORMATTER.format(System.currentTimeMillis()) + " " + num + "] " + msg);
        num++;
    }
}
