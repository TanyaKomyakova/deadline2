package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.ExactText;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;
import ru.netology.web.info.SQLHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.awt.SystemColor.info;
import static java.awt.SystemColor.text;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorMessage = $("[data-test-id=error-notification]");


    public VerificationPage validLogin(DataHelper.AuthInfo info){
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public LoginPage invalidLogin(DataHelper.AuthInvalidInfo invalidInfo) {
        loginField.setValue(invalidInfo.getLogin());
        passwordField.setValue(invalidInfo.getInvalidPassword());
        loginButton.click();
        return new LoginPage();
    }


    public LoginPage cleaning (){
        loginField.doubleClick().sendKeys(Keys.BACK_SPACE);
        passwordField.doubleClick().sendKeys(Keys.BACK_SPACE);
        return new LoginPage();
    }

    public LoginPage message () {
        errorMessage.shouldBe(visible).shouldHave(text(" Ошибка Ошибка! Неверно указан логин или пароль"));
        return new LoginPage();
    }


}
