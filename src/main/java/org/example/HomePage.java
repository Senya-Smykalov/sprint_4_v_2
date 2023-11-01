package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private static String URL = "https://qa-scooter.praktikum-services.ru/";
    private By buttonTopToOrder = (By.xpath("//div[1]/div[2]/button[1]"));
    private By buttonBottomToOrder = (By.xpath("//div[4]/div[2]/div[5]/button"));
    private By actualText = (By.id("accordion__panel-"));
    private By agreeWithCookie = (By.xpath(".//button[contains(@class, 'App_CookieButton')]"));
    private By goHomePage = (By.xpath("//a[@class='Header_LogoScooter__3lsAR']"));
    private By orderForm = (By.xpath("//div[@class='Order_Header__BZXOb']"));

    public void open() {
        driver.get(URL);
    }

    public void clickCookie() {
        driver.findElement(agreeWithCookie).click();
    }

    public void clickOrderTop() {
        driver.findElement(buttonTopToOrder).click();
    }

    public void clickOrderBottom() {
        driver.findElement(buttonBottomToOrder).click();
    }

    public void questionTitleClick(String question) {
        driver.findElement(By.xpath(".//div[text()='" + question + "']")).click();
    }

    public String questionText(int number) {
        return driver.findElement(By.id("accordion__panel-" + number)).getText();
    }

    public String questionActualText(int number) {
        return driver.findElement(By.id("accordion__panel-" + number)).getText();

    }

    public void buttonSamocatClick() {
        driver.findElement(goHomePage).click();
    }

    public String orderFormOpens() {
        return driver.findElement(orderForm).getText();
    }
}
