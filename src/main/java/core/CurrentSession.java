package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CurrentSession {

    ///public static WebDriver ddd = new ChromeDriver();

    static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    protected static void setDRIVER(WebDriver driver){
        DRIVER.set(driver);
    }

    public static WebDriver driver(){
        return DRIVER.get();
    }
}
