package org.example.Web_Automation.Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.example.Driver.Driver_Manage;
import org.example.Pages.Dashboard_Page;
import org.example.Pages.Login_Page;
import org.example.Utils.ProperReader;
import org.example.Web_Automation.TestBase.Test_Base;

import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class Login_Tests extends Test_Base {


   // private static final Logger logger = LogManager.getLogManager().getLogger(String.valueOf(Login_Tests.class));
   private static final Logger LOGGER = LogManager.getLogger(Login_Tests.class);



    // Copied and pasted the Below one
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify with the InValid Credentials are Not Working ")
    @Test(groups = {"P0"} ,priority = 1)

    public void testVWOLogin_Negative(Method method) throws Exception {


//        test = createTest(method.getName());
        
        Driver_Manage.getDriver().get(ProperReader.readKey("url"));

        // Builder Pattern By using . .
        // Abstraction (Hidden Clearly)

        String Expected_Result = new Login_Page().loginToVWO(false).error_message_text();// Removed After Login & Dashboard Page
        //LOGGER.info("Login Failed");
        String Actual_Result = ProperReader.readKey("Expected_Error");

        // Looks Better code compare to Pramod

       if (!Expected_Result.equalsIgnoreCase(Actual_Result)) {
           LOGGER.info("Login Failed");
           TakeScreenshot(method.getName(),Driver_Manage.getDriver());
       }else {
           LOGGER.info("Login Passed");
       }

        // AssertJ (NotBlank, Not null are common Assert)
        Assertions.assertThat(Expected_Result).isNotBlank().isNotNull().contains(ProperReader.readKey("Expected_Error"));
        //LOGGER.info("Login Passed");

        // If assertion Fails to take screen shot
//        try {
//            Assertions.assertThat(Expected_Result).isNotBlank().isNotNull().contains(ProperReader.readKey("Expected_Error"));
//            LOGGER.info("Login Passed");
//        } catch (AssertionError e) {
//            LOGGER.info("Assertion Failed");
//            TakeScreenshot(method.getName(),Driver_Manage.getDriver());
//        }


    }




    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify with the InValid Credentials are Not Working ")
    @Test(groups = {"P0" ,"Positive" } ,priority = 2)

    public void testVWOLogin_Positive() throws Exception {
        Driver_Manage.getDriver().get(ProperReader.readKey("url"));

        // Builder Pattern By using . .
        // Abstraction (Hidden Clearly)
        Dashboard_Page dashboardPage = new Login_Page().loginToVWO(true).afterLogin();
        String Expected_Result = dashboardPage.loggedInUserName();
        // AssertJ
        Assertions.assertThat(Expected_Result).isNotBlank().isNotNull().contains(ProperReader.readKey("Expected_Username"));

    }

}
