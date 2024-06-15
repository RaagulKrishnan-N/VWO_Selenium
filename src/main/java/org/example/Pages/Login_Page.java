package org.example.Pages;


import org.example.Base.Base_Page;
import org.example.Driver.Driver_Manage;
import org.example.Utils.ProperReader;
import org.openqa.selenium.By;


import java.time.Duration;

public class Login_Page extends Base_Page {

    // Page Drivers
  public Login_Page(){
       super();

  }


    // Page Locators If you Add Private Before By that is Encapsulation

    By username = By.id("login-username");
    By password = By.id("login-password" );
    By signButton = By.id("js-login-btn" );
    By sign_uplink= By.partialLinkText("Start a free trial"); // In Future, you can add extra locators
    By error_message = By.id("js-notification-box-msg");

// Page Actions

    public Login_Page loginToVWO(boolean invalid) throws Exception {

        if (!invalid) {
            enterInput(username, ProperReader.readKey("Invalid_Username"));
        } else {
            enterInput(username, ProperReader.readKey("username"));
        }
        enterInput(password, ProperReader.readKey("password"));
        ClickElement(signButton);
        return this;
    }

    // Negative
    public String error_message_text()  {

        // Instead of Driver your giving Driver_Manage.getDriver()
               VisibilityOfElement(error_message);
        return Driver_Manage.getDriver().findElement(error_message).getText();
    }


    public Dashboard_Page afterLogin(){
        return new Dashboard_Page();
    }
}









    // Negative
//    public String error_message_text() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"js-notification-box-msg\"]")));
//        return driver.findElement(error_message).getText();
//    }


