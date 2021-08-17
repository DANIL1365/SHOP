package utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4j2App {

    private static final Logger logger = LogManager.getLogger();

    @Test
    public void test1() {
        logger.info("App test log message.");
    }
}
