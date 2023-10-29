package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class HomePageObject {
    private static WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    private By agreeWithCookie = (By.xpath(".//button[contains(@class, 'App_CookieButton')]"));;
    //Открытие страницы сервиса
    private static String URL = "https://qa-scooter.praktikum-services.ru/";

    public void open() {
        driver.get(URL);
    }
    public void clickCookie() {
        driver.findElement(agreeWithCookie).click();
    }
     //Кнопка "заказать" сверху
    private By clickButtonTop = (By.xpath("//div[1]/div[2]/button[1]"));
    //Кнопка "заказать снизу"
    private By clickButtonBottom = (By.xpath("//div[4]/div[2]/div[5]/button"));
   //метод нажатия кнопки "заказать" сверху
    public void clickOrderTop(){
        driver.findElement(clickButtonTop).click();
    }
    //метод нажатия кнопки "заказать" снизу
    public void clickOrderBottom(){
        driver.findElement(clickButtonBottom).click();
    }

}
