import mainFiles.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class AcropliaAutoTests {
    @BeforeAll
    static void setUpAll() {
        Driver.setUpAll();
    }
    @BeforeEach
    void setUp() {
        Driver.setUp();
        TestHelper.openPage();
    }
    @AfterEach
    void tearDown() {
        Driver.tearDown();
    }
    @Test
    void shouldSignInWithEmailAndPassword() {
        TestHelper.sendKeysToElement(LoginPageTest.mailInput, TestData.mail);
        TestHelper.clickElement(LoginPageTest.blueNextButton);
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(LoginPageTest.passwordInput));
        TestHelper.sendKeysToElement(LoginPageTest.passwordInput, TestData.password);
        TestHelper.clickElement(LoginPageTest.enterButton);
    }
    @Test
    void shouldNotSignInWithEmptyEmailField() {
        TestHelper.clickElement(LoginPageTest.blueNextButton);
        TestHelper.clickElement(LoginPageTest.blueNextButton);
        assertFalse(TestHelper.findElement(LoginPageTest.passwordInput));
    }
    @Test
    void shouldNotSignInWithInvalidEmail() {
        TestHelper.sendKeysToElement(LoginPageTest.mailInput, TestData.wrongMail);
        LoginPageTest.findWrongAddressAlert();
        TestHelper.clickElement(LoginPageTest.blueNextButton);
        assertFalse(TestHelper.findElement(LoginPageTest.passwordInput));
    }
    @Test
    void shouldNotSignInWithNonExistingUser() {
        TestHelper.sendKeysToElement(LoginPageTest.mailInput, TestData.wrongEMail);
        LoginPageTest.findWrongUserAlert();
        TestHelper.clickElement(LoginPageTest.blueNextButton);
        assertFalse(TestHelper.findElement(LoginPageTest.passwordInput));
    }
    @Test
    void shouldSignInWithPhoneAndPassword() {
        TestHelper.clickElement(LoginPageTest.phoneNumber);
        TestHelper.sendKeysToElement(LoginPageTest.phoneInput, TestData.phone);
        TestHelper.clickElement(LoginPageTest.blueNextButton);
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(LoginPageTest.passwordInput));
        TestHelper.sendKeysToElement(LoginPageTest.passwordInput, TestData.password);
        TestHelper.clickElement(LoginPageTest.enterButton);
    }
    @Test
    void shouldSendTextMessage() {
        shouldSignInWithEmailAndPassword();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(ChatModule.blueContinueButton));
        TestHelper.clickElement(ChatModule.blueContinueButton);
        wait.until(visibilityOfElementLocated(ChatModule.peoples));
        TestHelper.clickElement(ChatModule.peoples);
        wait.until(visibilityOfElementLocated(ChatModule.skipAllButton));
        TestHelper.clickElement(ChatModule.skipAllButton);
        wait.until(visibilityOfElementLocated(ChatModule.messageInput));
        TestHelper.sendKeysToElement(ChatModule.messageInput, TestData.text);
        TestHelper.clickElement(ChatModule.sendMessageButton);
        TestHelper.sendKeysToElement(ChatModule.messageInput, TestData.text2);
        Driver.driver.findElement(ChatModule.messageInput).sendKeys(Keys.ENTER);
        TestHelper.sendKeysToElement(ChatModule.messageInput, TestData.link);
        TestHelper.clickElement(ChatModule.sendMessageButton);
        assertTrue(TestHelper.findElement(ChatModule.messageError));
    }
    @Test
    void shouldCreateCommunity() {
        shouldSignInWithEmailAndPassword();
        WebDriverWait wait = new WebDriverWait(Driver.driver, 15);
        wait.until(visibilityOfElementLocated(ChatModule.blueContinueButton));
        TestHelper.clickElement(ChatModule.blueContinueButton);
        TestHelper.clickElement(CommunityModule.createCommunity);
    }

}
