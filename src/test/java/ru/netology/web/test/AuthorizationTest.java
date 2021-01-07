package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.info.SQLHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationTest {

    @Test
    void logIn(){
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val personalArea = verificationPage.validVerify(SQLHelper.getCode());
    }

    @Test
    void logInWithWrongPassword(){
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInvalidInfoInfo = DataHelper.getAuthInvalidInfo();
        val loginPage1 = loginPage.invalidLogin(authInvalidInfoInfo);
        val message = loginPage.message();
        val page = loginPage.cleaning();
        val loginPage2 = loginPage.invalidLogin(authInvalidInfoInfo);
        val message2 = loginPage.message();
        val page2 = loginPage.cleaning();
        val loginPage3 = loginPage.invalidLogin(authInvalidInfoInfo);
        val message3 = loginPage.message();
        val errorMessageExpected = loginPage.message();
        assertEquals(errorMessageExpected, message3);
    }

    @AfterAll
    public static void afterAll() {
        SQLHelper.clear();
    }


}
