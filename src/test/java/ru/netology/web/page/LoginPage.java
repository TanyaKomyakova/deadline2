package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;
import ru.netology.web.info.SQLHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement  loginFailed = $("[data-test-id=error-notification]");


    public VerificationPage validLogin(DataHelper.AuthInfo info){
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public VerificationPage invalidLoginLogin() {
        loginField.setValue("vasya");
        passwordField.setValue("qwerty12345");
        loginButton.click();
        passwordField.doubleClick().sendKeys(Keys.BACK_SPACE);
        passwordField.setValue("qty12345");
        loginButton.click();
        passwordField.doubleClick().sendKeys(Keys.BACK_SPACE);
        passwordField.setValue("gdfgdyrth");
        loginButton.click();
        return new VerificationPage();
    }
}
