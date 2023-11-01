package edu.praktikum;

import org.example.HomePage;
import org.example.OrderFormPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class buttonBottomToOrder {
    //private final FirefoxOptions options = new FirefoxOptions();

    private WebDriver driver;
    private ChromeDriver webDriver;

    @Before
    public void mood() {
        //System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //driver = new FirefoxDriver(options);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    public void orderFormOpens() {
        HomePage homePage = new HomePage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        //Открываем страницу сервиса
        homePage.open();
        //соглашаемся с куки
        homePage.clickCookie();
        //нажимаем кнопку "заказать" снизу
        homePage.clickOrderBottom();
        //Проверяем, что форма открылась
        String orderFormOpens = homePage.orderFormOpens();
        Assert.assertTrue("Форма не открылась!", orderFormOpens.startsWith("Для кого самокат"));

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
