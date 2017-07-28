import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by hillel on 28.07.17.
 */
public class ChromeConfig {
    protected ChromeOptions options;
    protected WebDriver driver;

    @BeforeTest
    protected void startChrome(){
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--lang=en");
        System.setProperty("webdriver.chrome.driver", "Chromedriver/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
