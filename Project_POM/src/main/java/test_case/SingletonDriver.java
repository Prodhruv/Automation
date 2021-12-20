package test_case;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import  io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class SingletonDriver
{

    private static SingletonDriver instance_singletondriver =null;

    private WebDriver driver ;


    private SingletonDriver()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https:www.demoblaze.com");


    }
    @BeforeSuite
    public static SingletonDriver getInstanceOfSingletonDriver()
    {
        if (instance_singletondriver == null)
        {
            instance_singletondriver = new SingletonDriver();
        }
        return instance_singletondriver;
    }
    public WebDriver getDriver()
    {

        return driver;
    }
    @AfterSuite
    public void release_driver()
    {
        driver.quit();
    }
}
