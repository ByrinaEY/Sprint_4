package ru.yandex.praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.page.*;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)

public class OrderTest {
    private WebDriverFactory webDriverFactory = new WebDriverFactory();
    public WebDriver webDriver;
    private final String name;
    private final String surname;
    private final String adress;
    private final String stationName;
    private final String phoneNumber;
    private final String date;
    private final String period;
    private final String buttonOrderNumber;
       public OrderTest(String buttonOrderNumber, String name, String surname, String adress, String stationName, String phoneNumber, String date, String period) {
        this.buttonOrderNumber = buttonOrderNumber;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.stationName = stationName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Header", "Иван","Иванов", "г.Москва, ул. Победы д.5", "Черкизовская", "+79999991111", "05.05.2024", "двое суток"},
                {"Home", "Василий","Васильев", "г.Москва, ул. Победы д.35", "Крылатское", "+79999992222", "04.09.2024", "трое суток"}
        };
    }
@Before
public void setup(){
           //Для Google Chrome нужно поменять значение firefox на chrome. У меня на хроме тест виснет
    webDriver = WebDriverFactory.getWebDriver(System.getProperty("browser", "firefox"));
    webDriver.get("https://qa-scooter.praktikum-services.ru/");
}
    @Test
      public void createOrder(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickCreateOrderButton(buttonOrderNumber);

        OrderPageOne orderPageOne = new OrderPageOne(webDriver);

        orderPageOne.fillCustomerInfo(name, surname, adress, stationName, phoneNumber);
        orderPageOne.clickNextButton();

        OrderPageTwo orderPageTwo = new OrderPageTwo(webDriver);
        orderPageTwo.fillOrderData(date, period);
        orderPageTwo.clickOrderButton();

        OrderPageConfim orderPageConfim = new OrderPageConfim(webDriver);
        orderPageConfim.clickYesButton();

        OrderStatusPage orderStatusPage = new OrderStatusPage(webDriver);
        String orderStatusText = orderStatusPage.getOrderStatusText();
        MatcherAssert.assertThat(orderStatusText.substring(0,14), is("Заказ оформлен"));
       }

    @After
    public void teardown(){
        webDriver.quit();
    }
}
