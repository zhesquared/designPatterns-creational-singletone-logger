import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final Logger logger = Logger.getInstance();
        logger.log("App is started");

        final List<Integer> initialNumList = createInitialNumList(logger);
        System.out.println("This is a list of random numbers: " +  getStringFromList(initialNumList));

        final List<Integer> filteredNumList = filterNumList(initialNumList, logger);
        logger.log("Display the result");
        System.out.println("Filtered list: " + getStringFromList(filteredNumList));

        logger.log("App is complete");
    }

    private static List<Integer> createInitialNumList(Logger logger) {
        logger.log("User must enter the initial data for the list");
        final int listSize, maxValue;
        try {
            System.out.print("Please specify the size of the list: ");
            listSize = Integer.parseInt(SCANNER.nextLine());
            System.out.print("Enter upper bound for values: ");
            maxValue = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            logger.log("Failed to read input value");
            throw new RuntimeException(e);
        }

        logger.log("Create and fill a list");
        final Random random = new Random();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            result.add(random.nextInt(maxValue));
        }
        return result;
    }

    private static String getStringFromList(List<Integer> numList) {
        return numList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static List<Integer> filterNumList(List<Integer> numList, Logger logger) {
        logger.log("User must enter input to filter");
        final int threshold;
        try {
            System.out.print("Enter the threshold for the filter: ");
            threshold = Integer.parseInt(SCANNER.nextLine());
        } catch (Exception e) {
            logger.log("Failed to read input value");
            throw new RuntimeException(e);
        }

        final Filter filter = new Filter(threshold);
        return filter.filterOut(numList);
    }
}
