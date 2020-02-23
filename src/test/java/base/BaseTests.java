package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected String baseUrl = "https://www.mercadolibre.com.ar/";
    private String selenium_hub_url = "http://chrome:4444/wd/hub";


    @BeforeClass
    public void setUp() {
        String env = System.getenv("MY_ENV");
        if (env == null) { env = "local"; }
        switch (env.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "docker":
                try {
                    URL url = new URL(selenium_hub_url);
                    driver = new RemoteWebDriver(url, getCapabilities("chrome"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        if (!driver.getCurrentUrl().equals(baseUrl)) { driver.get(baseUrl); };
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private Capabilities getCapabilities(String browserName) {
        DesiredCapabilities capabilities = null;
        switch (browserName.toLowerCase()) {
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            default:
                capabilities = DesiredCapabilities.chrome();
        }

        return capabilities;
    }
}
