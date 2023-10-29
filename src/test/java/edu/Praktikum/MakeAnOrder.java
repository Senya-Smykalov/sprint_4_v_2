package edu.Praktikum;

import org.example.HomePageObject;
import org.example.OrderFormPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

public class MakeAnOrder {
    private final FirefoxOptions options = new FirefoxOptions();

    private WebDriver driver;
    //private ChromeDriver webDriver;
    @Before
    public void mood() {
        System.setProperty("webdriver.gecko.driver","D:\\geckodriver\\geckodriver.exe");
        //options.addArguments("--no-sandbox","--headless","--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);

        //ChromeOptions options = new ChromeOptions();
        //webDriver = new ChromeDriver(options);
    }

        @Test
        public void makeOrderTopButton(){
        HomePageObject homePageObject = new HomePageObject(driver);
        OrderFormPageObject orderFormPageObject = new OrderFormPageObject(driver);
        //Открываем страницу сервиса
        homePageObject.open();
        //Соглашаемся с куки
        homePageObject.clickCookie();
        //Нажимаем кнопку "заказать" сверху
        homePageObject.clickOrderTop();
        //Ожидание, пока появится форма заказа и поле "имя"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='* Имя']")));
        //Заполняем первую страницу формы заказа
        orderFormPageObject.textNumberOne("Иван","Иванов","г.Город ул.Улица д.1 кв.16","Бульвар Рокоссовского","79122223344");
        //Клик кнопку "дальше"
        orderFormPageObject.further();
        //Выбираем данные во второй форме заказа
        orderFormPageObject.textNumberTwo();
        //заполнение поля "комментарий для курьера"
        orderFormPageObject.commentForTheCourier("Rjvvtynfhbq lkz rehmthf");
        //Ожидание появляение кнопки "заказать"
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Заказать']")));
        //Нажать кнопку "заказать"
        orderFormPageObject.orderButton();
        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Да')]")));
        //В сплывающем окне нажать подтвердить заказ
        orderFormPageObject.yes();
            // Проверка, что появилось окно об успешном заказе
            String successfulOrder = driver.findElement(By.xpath(".//div[contains(@class, 'Order_ModalHeader')]")).getText();
            Assert.assertTrue("Ошибочка", successfulOrder.startsWith("Заказ оформлен"));
        }
    @Test
    public void makeOrderBottomButton(){
        HomePageObject homePageObject = new HomePageObject(driver);
        OrderFormPageObject orderFormPageObject = new OrderFormPageObject(driver);
        //Открываем страницу сервиса
        homePageObject.open();
        //Соглашаемся с куки
        homePageObject.clickCookie();
        //Нажимаем кнопки "заказать" скнизу
        homePageObject.clickOrderBottom();
        //Ожидание, пока появится форма заказа и поле "имя"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='* Имя']")));
        //Заполняем первую страницу формы заказа
        orderFormPageObject.textNumberOne("Петр","Петров","г.Городской ул.Уличная д.0 кв.0","Черкизовская","79122225566");
        //Клик кнопку "дальше"
        orderFormPageObject.further();
        //Выбираем данные во второй форме заказа
        orderFormPageObject.textNumberTwo();
        //заполнение поля "комментарий для курьера"
        orderFormPageObject.commentForTheCourier("Курьер - класс");
        //Ожидание появляение кнопки "заказать"
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Заказать']")));
        //Нажать кнопку "заказать"
        orderFormPageObject.orderButton();
        //Ождание кнопки "подтвердить заказ"
        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Да')]")));
        //В сплывающем окне нажать подтвердить заказ
        orderFormPageObject.yes();
        //проверяем
        String successfulOrder = driver.findElement(By.xpath(".//div[contains(@class, 'Order_ModalHeader')]")).getText();
        Assert.assertTrue("Ошибочка", successfulOrder.startsWith("Заказ оформлен"));

    }

   @After
        public void teardown(){driver.quit();}
}
