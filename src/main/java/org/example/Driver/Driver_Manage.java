package org.example.Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class Driver_Manage {

        static WebDriver driver;
        private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

        public static void setDriver(WebDriver driverRef){
            dr.set(driverRef);
        }

        public static WebDriver getDriver() {
            return dr.get();
        }

        public static void unload(){
            dr.remove();
        }



        @BeforeSuite
        public static void init(){

        // Todo #1 - Need to make support for Firefox , Edge , & Safari By Implementing Switch case

        if(getDriver()==null){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        setDriver(new ChromeDriver(options));
        }


        }

        @AfterSuite
        public static void down(){
        if(getDriver() != null){ // Not Equal
        getDriver().quit();
        }

        }

}

