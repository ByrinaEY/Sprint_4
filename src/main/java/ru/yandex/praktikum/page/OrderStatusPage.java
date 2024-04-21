package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderStatusPage {
    private final WebDriver webDriver;
    private final By orderStatusTextLocator = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public OrderStatusPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public String getOrderStatusText(){
        WebElement orderStatusText = webDriver.findElement(orderStatusTextLocator);
        return orderStatusText.getText();
    }
}
