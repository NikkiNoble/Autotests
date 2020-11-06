package mainFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestHelper {
    public static By continueButton = By.className("btn-nofiled-blue");
    public static By signInButton = By.className("MuiButton-label");
    public static void openPage() {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        Driver.driver.get("http://localhost:3000");
//        Driver.driver.get("https://app-dev.acroplia.com/login");
        wait.until(visibilityOfElementLocated(continueButton));
        Driver.driver.findElement(continueButton).click();
        Driver.driver.findElement(signInButton).click();
    }
    public static boolean findElement(By element) {
        try {
            Driver.driver.findElement(element).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static void sendKeysToElement (By element, String keys) {
        Driver.driver.findElement(element).sendKeys(keys);
    }
    public static void clickElement (By element) {
        Driver.driver.findElement(element).click();
    }
}
