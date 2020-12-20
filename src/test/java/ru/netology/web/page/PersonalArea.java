package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PersonalArea {
    private SelenideElement dashboard = $("[data-test-id=dashboard]");

    public PersonalArea (){
        dashboard.shouldBe(Condition.visible);
    }
}
