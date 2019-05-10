package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonApi {

    public static WebDriver driver = null;

    @Parameters({"platform", "url", "browser"})

    @BeforeMethod
    public static WebDriver setupDriver(String platform, String url, String browser) {
        if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/driver/chromedriver");
            driver = new ChromeDriver();
        } else if (platform.equalsIgnoreCase("mac" ) && browser.equalsIgnoreCase("mozila")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/driver/geckodriver");
            driver = new FirefoxDriver();
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else  if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("mozila")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }


    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }
}
