package mainFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPageTest {
    private static By mailInput = By.xpath("//input[@name='email'][@placeholder='Заполните...']");
    private static By blueNextButton = By.xpath("//div[@data-xpath='signin_next']");
    private static By passwordInput = By.xpath("//input[@name='password'][@placeholder='Пароль']");
    private static By enterButton = By.xpath("//div[@data-xpath='signin_btn']");
    private static By workingDesk = By.className("_14CaT");

    public static void loginToAcroplia() {
        TestHelper.openPage();
        Driver.driver.findElement(mailInput).sendKeys("acroplia.avtobot@gmail.com");
        Driver.driver.findElement(blueNextButton).click();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(passwordInput));
        Driver.driver.findElement(passwordInput).sendKeys("123456");
        Driver.driver.findElement(enterButton).click();
        wait.until(visibilityOfElementLocated(workingDesk));
    }
}
