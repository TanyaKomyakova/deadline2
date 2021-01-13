package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.info.SQLHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorizationTest {

    @AfterAll
    public static void afterAll() {
        SQLHelper.clear();
    }

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldGetBlockerMessageTripleWrongPasswordLogin(){
        val loginPage = new LoginPage();
        val authInvalidInfoInfo = DataHelper.getAuthInvalidInfo();
        loginPage.login(authInvalidInfoInfo);
        loginPage.getBadLoginOrPasswordMessage();
        loginPage.cleaning();
        loginPage.login(authInvalidInfoInfo);
        loginPage.getBadLoginOrPasswordMessage();
        loginPage.cleaning();
        loginPage.login(authInvalidInfoInfo);
        loginPage.getBlockedSystemMessage();

    }

    @Test
    void shouldSuccessfulLogIn(){
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        verificationPage.validVerify(SQLHelper.getCode());
    }
}
