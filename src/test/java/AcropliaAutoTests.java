import mainFiles.Driver;
import mainFiles.LoginPageTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AcropliaAutoTests {
    @BeforeAll
    static void setUpAll() {
        Driver.setUpAll();
    }
    @BeforeEach
    void setUp() {
        Driver.setUp();
    }
    @AfterEach
    void tearDown() {
        Driver.tearDown();
    }
    @Test
    void shouldSignInWithEmailAndPassword() {
        LoginPageTest.loginToAcroplia();
    }

}
