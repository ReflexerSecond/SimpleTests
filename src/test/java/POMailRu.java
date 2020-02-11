import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class POMailRu implements IPage {

    public void open() {
        Selenide.open("https://mail.ru");
    }

    public SelenideElement getEmailField() {
        return $("[id =\"mailbox:login\"]");
    }

    public SelenideElement getPasswordField() {
        return $("input[id = \"mailbox:password\"]");
    }

    public SelenideElement getLoginButton() {
        return $("input[type=\"submit\"][class=\"o-control\"]");
    }

    public SelenideElement getEmailPreview() {
        return $("#PH_user-email").shouldHave(text("shoggothwithspoon@mail.ru"));
    }

    public SelenideElement getVisibleErrorMessage() {
        SelenideElement element = $("#mailbox\\:error");
        element.waitUntil(exist,500);
        if (element.exists() && element.is(visible)) {
            return element;
        } else {
            return null;
        }
    }
}
