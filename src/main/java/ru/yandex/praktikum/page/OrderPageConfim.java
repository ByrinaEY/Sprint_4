package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageConfim {
    private final WebDriver webDriver;
    private final By yesButtonLocator = By.xpath("//button[text()='Да']");

    public OrderPageConfim(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickYesButton(){
        WebElement yesButton = webDriver.findElement(yesButtonLocator);
        yesButton.click();
    }
}
