package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageTwo {
    private final WebDriver webDriver;
    private final By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentPeriodLocator = By.xpath("//div[text()='* Срок аренды']");
    private final String rentPeriodItemMenuLocator = "//div[text()='%s']";
    private final By createOrderButtonLocator = By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]/button[text() = 'Заказать']");

       public OrderPageTwo (WebDriver webDriver){
           this.webDriver = webDriver;
       }
       public void fillOrderData(String date, String period){
           WebElement dateInput = webDriver.findElement(dateInputLocator);
           dateInput.sendKeys(date, Keys.ENTER);

           WebElement rentPeriodInput = webDriver.findElement(rentPeriodLocator);
           rentPeriodInput.click();

           WebElement rentPeriodItemMenu = webDriver.findElement(By.xpath(String.format(rentPeriodItemMenuLocator, period)));
           rentPeriodItemMenu.click();


       }
       public void clickOrderButton(){
           WebElement createOrderButton = webDriver.findElement(createOrderButtonLocator);
           createOrderButton.click();
       }
}
