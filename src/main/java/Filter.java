import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        final Logger logger = Logger.getInstance();
        logger.log("Start filtering");

        final List<Integer> result = source.stream()
                .filter(num -> {
                    final boolean isNumMatch = num >= threshold;
                    if (isNumMatch) {
                        logger.log("Element \"" + num + "\" is passed");
                    } else {
                        logger.log("Element \"" + num + "\" does not pass");
                    }
                    return isNumMatch;
                })
                .collect(Collectors.toList());

        logger.log("Items in the original list: " +
                source.size() +
                "; elements left: " +
                result.size());

        return result;
    }
}

