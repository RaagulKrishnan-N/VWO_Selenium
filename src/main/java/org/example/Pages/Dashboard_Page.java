package org.example.Pages;

import org.example.Base.Base_Page;
import org.openqa.selenium.By;

// Single Inheritance (By using extends)

public class Dashboard_Page  extends Base_Page {

   Dashboard_Page(){

   }


    // Page Locators
    By userNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");




    // Page Actions
    public String loggedInUserName()  {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa=\"lufexuloga\"]")));
        VisibilityOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }


}


