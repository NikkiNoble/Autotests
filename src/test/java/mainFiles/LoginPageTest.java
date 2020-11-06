package mainFiles;

import org.openqa.selenium.By;

public class LoginPageTest {
    public static By mailInput = By.xpath("//input[@name='email'][@placeholder='Заполните...']");
    public static By phoneInput = By.xpath("//input[@name='phone']");
    public static By blueNextButton = By.xpath("//div[@data-test-id='signin_next']");
    public static By passwordInput = By.xpath("//input[@name='password'][@placeholder='Пароль']");
    public static By enterButton = By.xpath("//div[@data-test-id='signin_btn']");
    public static By workingDesk = By.className("_14CaT");
    public static By phoneNumber = By.cssSelector("[data-test-id='byPhone']");
    public static By wrongAddress = By.xpath("//*[contains(text(), 'Неверный адрес электронной почты')]");
    public static By wrongUser = By.xpath("//*[contains(text(), 'Пользователь не найден')]");
    public static void findWrongAddressAlert() {
        Driver.driver.findElement(wrongAddress).isDisplayed();
    }
    public static void findWrongUserAlert() {
        Driver.driver.findElement(wrongUser).isDisplayed();
    }

}
