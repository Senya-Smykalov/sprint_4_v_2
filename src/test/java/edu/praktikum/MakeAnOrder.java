package edu.praktikum;

import org.example.HomePage;
import org.example.OrderFormPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MakeAnOrder {
    //private final FirefoxOptions options = new FirefoxOptions();

    private WebDriver driver;
    private ChromeDriver webDriver;
    private String name;
    private String surname;
    private String address;

    private String metro;
    private String phoneNumber;
    private String comment;

    public MakeAnOrder(String name, String surname, String address, String metro, String phoneNumber, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "г.Городской, ул. Уличная, д.0, кв.0", "Бульвар Рокоссовского", "79998887766", "Курьер - супер"},
                {"Сергей", "Серёгин", "гор.Город, улица Улица, дом пять квартира 6", "Сокольники", "79887654321", "Надеюсь у тебя всё хорошо"}

        });

    }

    @Before
    public void mood() {
        //System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //driver = new FirefoxDriver(options);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    public void makeOrder() {
        HomePage homePage = new HomePage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);
        //Открываем страницу сервиса
        homePage.open();
        //Соглашаемся с куки
        homePage.clickCookie();
        //Нажимаем кнопку "заказать" сверху
        homePage.clickOrderTop();
        //Заполняем первую страницу формы заказа
        orderFormPage.textNumberOne(name, surname, address, metro, phoneNumber);
        //Клик кнопку "дальше"
        orderFormPage.furtherClick();
        //Выбираем данные во второй форме заказа
        orderFormPage.textNumberTwo();
        //заполнение поля "комментарий для курьера"
        orderFormPage.commentForTheCourier(comment);
        //Нажать кнопку "заказать"
        orderFormPage.orderButtonClick();
        //В сплывающем окне нажать подтвердить заказ
        orderFormPage.yesClick();
        // Проверка, что появилось окно об успешном заказе
        String successfulOrder = orderFormPage.checkCompleteOrder();
        Assert.assertTrue("Ошибочка", successfulOrder.startsWith("Заказ оформлен"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
