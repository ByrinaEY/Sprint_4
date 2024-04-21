package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageOne {
    private final WebDriver webDriver;
    //Локатор для поля ввода имени
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    private final By adressInputLocator =By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final String stationLocator = "//div[text()='%s']";
    public OrderPageOne (WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    //метод заполнения данных о заказчике
    public void fillCustomerInfo(String name, String surname, String adress, String stationName, String phoneNumber) {

        WebElement nameInput = webDriver.findElement(nameInputLocator);
        nameInput.sendKeys(name);

        WebElement surnameInput = webDriver.findElement(surnameInputLocator);
        surnameInput.sendKeys(surname);

        WebElement adressInput = webDriver.findElement(adressInputLocator);
        adressInput.sendKeys(adress);

        WebElement subwayInput = webDriver.findElement(subwayInputLocator);
        subwayInput.click();
        WebElement station = webDriver.findElement(By.xpath(String.format(stationLocator, stationName)));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", station);
        station.click();

        WebElement phoneInput = webDriver.findElement(phoneInputLocator);
        phoneInput.sendKeys(phoneNumber);

    }

    public void clickNextButton() {
        WebElement nextButton = webDriver.findElement(By.xpath("//button[text()='Далее']"));
        nextButton.click();
    }
}
