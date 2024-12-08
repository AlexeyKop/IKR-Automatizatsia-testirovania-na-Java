package com.max;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class UITest_new extends BaseUITest {

    @Test
    void testGBNotEmailLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();

        // Ввод некорректного логина и пароля
        loginPage.enterLogin("login");
        loginPage.enterPassword("password");

        loginPage.clickLoginButton();
        
        // Проверка отображения ошибки логина
        Assertions.assertFalse(
                driver.findElements(By.xpath("//li[text()='Введите адрес электронной почты.']")).isEmpty(),
                "Текст ошибки 'Введите адрес электронной почты.' не найден!"
        );

    }

    @Test
    void testGBWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        
        // Ввод корректного логина и пропуск пароля
        loginPage.enterLogin("login@login.ru");

        loginPage.clickLoginButton();
        
        // Проверка отображения ошибки пароля
        Assertions.assertFalse(
                driver.findElements(By.xpath("//li[text()='Обязательное поле.']")).isEmpty(),
                "Текст ошибки 'Обязательное поле.' не найден!"
        );


    }
}
