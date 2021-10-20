package sb.com.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.*;

public class LogBack {
    private static final Logger logger = LoggerFactory.getLogger(
            LogBack.class);
    private static final Marker IMPORTANT =
            MarkerFactory.getMarker("IMPORTANT");

//    private static final String FILENAME = "C:\\study\\3_year_of_pain\\SB\\SpringBootPractice\\src\\main\\java\\sb\\com\\project\\log";

    public static void main(String[] args) {
        MDC.put("user", "mariia.barabukha@ukma.edu.ua");
        logger.info("This is the first INFO level log message!");

        MDC.put("executionStep", "one");
        logger.info(IMPORTANT,"This is the second INFO level log message!");

        MDC.put("executionStep", "two");
        logger.info("This is the third INFO level log message!");
    }
}
