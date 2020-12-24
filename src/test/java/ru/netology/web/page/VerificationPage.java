package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import ru.netology.web.info.SQLHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage(){
        codeField.shouldBe(Condition.visible);
    }

    public PersonalArea validVerify(String code){
        codeField.setValue(code);
        verifyButton.click();
        return new PersonalArea();
    }
}
