package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class OrderFormPageObject {
    private static WebDriver driver;

    public OrderFormPageObject (WebDriver driver) {
        this.driver = driver;
    }
    private By textName = (By.xpath("//input[@placeholder='* Имя']"));
    //Поле формы заказа "Фамилия"
    private By textSurname = (By.xpath("//input[@placeholder='* Фамилия']"));
    //Поле формы заказа "Адрес"
    private By textAdress = (By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"));
    //Поле формы заказа "Станция метро"
    private By textMetro = (By.xpath("//input[@placeholder='* Станция метро']"));
    //Поле формы заказа "Номер телефона"
    private By textPhoneNumber = (By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"));
    //Кнопка "Далее" для дальнейшего оформления заказа
    private By clickButtonFurther = (By.xpath("//button[text()='Далее']"));
    //Поле формы заказа "Дата заказа"
    private By textOrderDate = (By.xpath("//input[@placeholder='* Когда привезти самокат']"));
    //выбор даты
    private By getOrderDate = (By.xpath("//div[@aria-label='Choose понедельник, 30-е октября 2023 г.']"));
    //Поле формы заказа "Срок аренды"
    private By textRentalPeriod = (By.xpath("//div[text()='* Срок аренды']"));
    //Выбор срока аренды (текст можно заменить на любой, необходимый)
    private By textNumberOfDays = (By.xpath("//div[text()='трое суток']"));
    //Поле формы заказа - выбор цвета "Чёрный жемчуг"
    private By textBlackPearl = (By.xpath("//input[@id='black' and @type='checkbox']"));
    //Поле формы заказа - выбор цвета  "Серая безысходность"
    private By grayHopelessness = (By.xpath("//input[@id='grey' and @type='checkbox']"));
    //Поле формы заказа "Комменатрий для курьера"
    private By textComment = (By.xpath("//input[@placeholder='Комментарий для курьера']"));
    //Клик в сплывающем окне "Вы дейсвтительно хотите оформить заказ"
    private By order = (By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"));
    private By clickYes = (By.xpath("//button[contains(text(), 'Да')]"));
    //Кнопка "проверить статус" после оформления заказа
    private By clickViewStatus = (By.xpath("//button[text()='Посмотреть статус']"));

    public void textNumberOne(String name, String surname, String address, String metro, String phoneNumber){
        driver.findElement(textName).sendKeys(name);
        driver.findElement(textSurname).sendKeys(surname);
        driver.findElement(textAdress).sendKeys(address);
        driver.findElement(textMetro).sendKeys(metro + ARROW_DOWN + ENTER);
        driver.findElement(textPhoneNumber).sendKeys(phoneNumber);
    }
    public void further(){
        driver.findElement(clickButtonFurther).click();
    }
    public void textNumberTwo() {
        driver.findElement(textOrderDate).click();
        driver.findElement(getOrderDate).click();
        driver.findElement(textRentalPeriod).click();
        driver.findElement(textNumberOfDays).click();
        driver.findElement(textBlackPearl).click();
    }
    public void commentForTheCourier(String comment){
        driver.findElement(textComment).sendKeys(comment);
    }
    public void orderButton(){
        driver.findElement(order).click();
    }
    public void yes(){
        driver.findElement(clickYes).click();
    }


}
