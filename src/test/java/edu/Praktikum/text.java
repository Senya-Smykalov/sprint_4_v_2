package edu.Praktikum;
import org.example.HomePageObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
class ParameterizedTest {
    private String question;
    private String text;
    private int number;
    public  ParameterizedTest(String question, String text,int number) {
        this.question = question;
        this.text = text;
        this.number = number;
    }

}
@RunWith(Parameterized.class)
public class text {
    private String question;
    private String text;
    private int number;
    private WebDriver driver;
    public text(String question, String text, int number){
        this.question = question;
        this.text = text;
        this.number = number;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",0},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",1},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",4},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",5},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",6},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.",7},
        });
    }

    @Before
    public void mood() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
     public void сheckText() {
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.open();
        homePageObject.clickCookie();
    // Выполняем скролл до пункта с текстом "Вопрос о важном"
    WebElement element = driver.findElement((By.xpath("//div[contains(text(), 'Вопросы о важном')]")));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    //Клик на заголовок вопроса
        driver.findElement(By.xpath(".//div[text()='"+ question +"']")).click();
        // Получение текста вопроса о важном
        driver.findElement(By.id("accordion__panel-" + number)).getText();
        //Актуальный текст
        String actualText = driver.findElement(By.id("accordion__panel-" + number)).getText();
        //Сравнение ожидаемого и фактического результата
        assertEquals("Неправильный текст!",text,actualText);
    }
        @After
     public void teardown(){driver.quit();}
}
