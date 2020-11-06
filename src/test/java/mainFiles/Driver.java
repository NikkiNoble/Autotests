package mainFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static WebDriver driver;
    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver_win32\\chromedriver.exe");
    }
    public static void setUp() {
        driver = new ChromeDriver();
    }
    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
