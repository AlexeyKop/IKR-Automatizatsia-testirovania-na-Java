package com.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    // Локаторы для элементов страницы
    private final By loginField = By.xpath("//input[@name='user[email]']");
    private final By passwordField = By.xpath("//input[@name='user[password]']");
    private final By loginButton = By.xpath("//input[@value='Войти']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://gb.ru/login");
    }

    public void enterLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
