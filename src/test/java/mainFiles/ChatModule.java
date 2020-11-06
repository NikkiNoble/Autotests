package mainFiles;

import org.openqa.selenium.By;

public class ChatModule {
    public static By blueContinueButton = By.cssSelector(".btn-size-3-normal");
    public static By skipAllButton = By.className("onboarding_buttonSkipAll_3cKnd");
    public static By peoples = By.cssSelector("[data-test-id='peoples_button']");
    private static By contactButton = By.cssSelector("");
    public static By messageInput = By.cssSelector("[data-test-id='chat_input']");
    public static By sendMessageButton  = By.cssSelector("[data-test-id='send_message_button']");
    private static By message = By.xpath("//*[contains(text(), 'Hello!')]");
    private static By workSpace = By.cssSelector("[href='/my-desk']");
    private static By chatIcon = By.cssSelector("[data-onboarding='chatTab']");
    public static By messageError = By.xpath("//*[contains(text(), 'Не отправлено. Повторить?')]");
}
