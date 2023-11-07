package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

///This class will provide the dynamic wait times  to perform the actions after page loaded completed///
public class PageLoadWait {
    private static final Logger logger = LoggerFactory.getLogger(PageLoadWait.class);

    public static void waitForPageToLoad(WebDriver driver) throws Exception {
        int waitTime = 0;
        boolean isPageLoadComplete = false;
        do {
            isPageLoadComplete = ((String) ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState")).equalsIgnoreCase("Complete");
            logger.info("waiting for page to load");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
            waitTime++;
            if (waitTime > 250)
                break;
        } while (!isPageLoadComplete);
        if (!isPageLoadComplete) {
            logger.info("Unable to load webpage in default timeout 250 seconds");
            throw new Exception("Page failed to load");
        }
    }

}
