package core;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CurrentSession {

    static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    protected static void setDRIVER(WebDriver driver){
        DRIVER.set(driver);
    }

    public static WebDriver driver(){
        return DRIVER.get();
    }
}
