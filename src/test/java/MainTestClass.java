import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestClass {
    @BeforeTest
    public void screener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }
    @Test
    public void successLoginToMailRu() {
        final String email = "shoggothwithspoon@mail.ru";
        final String password = "stone123";

        POMailRu mailRu = new POMailRu();
        mailRu.open();
        mailRu.getEmailField().setValue(email);
        mailRu.getLoginButton().click();
        mailRu.getPasswordField().setValue(password);
        mailRu.getLoginButton().click();
        Assert.assertEquals(mailRu.getEmailPreview().text(), email);
    }

    @Test
    public void failedSuccessLoginToMailRu() {
        final String email = "shoggothwithspoon@mail.ru";
        final String password = "stone1234";

        POMailRu mailRu = new POMailRu();
        mailRu.open();
        mailRu.getEmailField().setValue(email);
        mailRu.getLoginButton().click();
        mailRu.getPasswordField().setValue(password);
        mailRu.getLoginButton().click();
        Assert.assertEquals(mailRu.getEmailPreview().text(), email);
    }

    @Test
    public void loginToMailRuIncorrectPassword() {
        final String email = "shoggothwithspoon@mail.ru";
        final String password = "stone1234";

        POMailRu mailRu = new POMailRu();
        mailRu.open();
        mailRu.getEmailField().setValue(email);
        mailRu.getLoginButton().click();
        mailRu.getPasswordField().setValue(password);
        mailRu.getLoginButton().click();
        Assert.assertTrue(mailRu.getVisibleErrorMessage() != null);
    }
}
