package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver webDriver;
    //описание локаторов для главной страницы заказа самоката
    private final String createOrderButtonLocator= "//div[contains(@class, '%s')]/button[text()='Заказать']";
    private final By cookiesButtonLocator = By.xpath("//button[text()='да все привыкли']");
    private final String questionLocator = "accordion__heading-%s";
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";
   public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //нажатие клаивиши создать заказ
    public void clickCreateOrderButton(String buttonOrderNumber) {

       WebElement createOrderButton = webDriver.findElement(By.xpath(String.format(createOrderButtonLocator, buttonOrderNumber)));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", createOrderButton);
        createOrderButton.click();
   }
//согласие на использование Cookie
    public void closeCookieWindow() {
        webDriver.findElement(cookiesButtonLocator).click();
    }
// получение вопроса списка
    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator,index)));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
//проверка отображения ответа в списке
    public boolean answerIsDisplayed(String expectedAnswer) {
       WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator,expectedAnswer)));
       return element.isDisplayed();

    }
}
