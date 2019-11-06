package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserFactory extends CurrentSession{

    @BeforeSuite
    public void before(){
        System.out.println("Run Before Suite");
        setUpBrowser();
    }

    @AfterSuite
    public void after(){
        if(driver()!=null){
            driver().quit();
        }
    }

    private void setUpBrowser() {
        WebDriver driver = new ChromeDriver();
        setDRIVER(driver);
        driver().manage().window().setSize(new Dimension(1600, 2000));
    }

}
