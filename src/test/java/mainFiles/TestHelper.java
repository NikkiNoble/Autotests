package mainFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestHelper {
    public static By continueButton = By.className("btn-nofiled-blue");
    public static void openPage() {
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        Driver.driver.get("https://app-dev.acroplia.com/login");
        wait.until(visibilityOfElementLocated(continueButton));
        Driver.driver.findElement(continueButton).click();
    }
}
