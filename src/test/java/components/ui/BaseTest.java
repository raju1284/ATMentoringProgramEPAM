package components.ui;

import com.ui.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import utilities.ReadPropertyFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.openqa.selenium.remote.CapabilityType.PROXY;

public class BaseTest  {
    ReadPropertyFile fr = new ReadPropertyFile();
    private WebDriver driver;


    public WebDriver setUp() throws IOException {

        String browser =  fr.getPropertyValue("browser");

        Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();

        if (browser.equalsIgnoreCase("edge"))
        {
            try {
                String[] pathNames = {absolutePath, "\\msedgedriver.exe" };
                String path = String.join(File.pathSeparator, pathNames);
                System.setProperty("webdriver.edge.driver",path);
                EdgeOptions options = new EdgeOptions();
                options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                options.addArguments("--remote-allow-origins=*");
                options.setCapability("ignore-certificate-errors", true);

                WebDriverManager.edgedriver().avoidResolutionCache().proxy(PROXY).setup();
                driver = new EdgeDriver(options);
            }
            catch (Exception exp){
                exp.printStackTrace();
            }
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            String[] pathNames = {absolutePath, "\\chromedriver.exe" };
            String path = String.join(File.pathSeparator, pathNames);
            System.setProperty("webdriver.chrome.driver",path);
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            options.addArguments("--remote-allow-origins=*");
            options.setCapability("ignore-certificate-errors", true);

            WebDriverManager.chromedriver().avoidResolutionCache().proxy(PROXY).setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }

}
