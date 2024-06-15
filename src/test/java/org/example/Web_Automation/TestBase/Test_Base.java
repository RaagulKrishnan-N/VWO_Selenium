package org.example.Web_Automation.TestBase;

import io.qameta.allure.Allure;
import org.example.Driver.Driver_Manage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.ByteArrayInputStream;

public class Test_Base {

    // This is a Base for Tests (Here also your gonna use common like Call to driver , screenshot)
    // Why we are using Protected ? -> To make sure only Login page can use this its good practice to make all base class protected


    @BeforeSuite
    protected void setUp(){
        Driver_Manage.init();

        // We can use this generic if our URL is same if Not better use it in Tests
       // Driver_Manage.getDriver().get(ProperReader.readKey("url"));
    }


    @AfterSuite
    protected void TearDown(){
        Driver_Manage.down();
    }

 // On Demand Screenshot another one we can create by listener for taking failures
//protected void TakeScreenshot(String name , WebDriver Driver){
//// Looks Scary
//    Allure.addAttachment(name,new ByteArrayInputStream(((TakesScreenshot)Driver_Manage.getDriver()).getScreenshotAs(OutputType.BYTES)));
//}
protected void TakeScreenshot(String name , WebDriver Driver_Manage){
  Allure.addAttachment(name,new ByteArrayInputStream(((TakesScreenshot)Driver_Manage).getScreenshotAs(OutputType.BYTES)));
}
}
