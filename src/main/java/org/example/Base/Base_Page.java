package org.example.Base;

import org.example.Driver.Driver_Manage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_Page {
    // Common Functionality Like Enter, ClickElement, Wait


    protected Base_Page(){
    }

    protected void enterInput (By by , String Key){
        Driver_Manage.getDriver().findElement(by).sendKeys(Key);
    }

    // Overloading (Polymorphism)

//    protected void enterInput(WebElement e, String key){
//       e.sendKeys(key);
//    }

    protected void ClickElement (By by){
        Driver_Manage.getDriver().findElement(by).click();
    }

    protected WebElement getElement (By key){

        return Driver_Manage.getDriver().findElement(key);
    }

    // Presence Not Working
// protected WebElement presenceOfElement(final By elementLocation) {
//        return new WebDriverWait(Driver_Manage.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
//    }

    protected WebElement VisibilityOfElement(final By elementLocation) {
       return new WebDriverWait(Driver_Manage.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
  }


    protected WebElement elementToBeClickable(final By elementIdentier) {
        WebElement element = new WebDriverWait(Driver_Manage.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementIdentier));
        return element;
    }

}
