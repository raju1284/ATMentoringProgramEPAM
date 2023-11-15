package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import utilities.ReadPropertyFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebDriverManager {
    private WebDriver driver;

    public ReadPropertyFile fr = new ReadPropertyFile();

    public WebDriver getDriver() throws IOException {
        String browser = fr.getPropertyValue("browser");
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        if (browser.equalsIgnoreCase("chrome")) {
            String[] pathNames = {absolutePath, "\\drivers\\chromedriver.exe"};
            String path = String.join(File.pathSeparator, pathNames);
            System.out.println(path);
            System.setProperty("webdriver.chrome.driver", path.replaceAll(";", ""));
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.addArguments("--remote-allow-origins=*");
            options.setCapability("ignore-certificate-errors", true);
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
