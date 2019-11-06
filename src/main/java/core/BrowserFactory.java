package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BrowserFactory extends CurrentSession{

    @BeforeSuite
    @Parameters({"before"})
    public void before(@Optional("suite")String before){
        if(before.equals("suite")) {
            System.out.println("Run Before Suite");
            setUpBrowser();
        }
    }

    @BeforeTest
    @Parameters({"before"})
    public void beforeT(@Optional("")String before){
        if(before.equals("test")) {
            System.out.println("Run Before Test");
            setUpBrowser();
        }
    }

    @AfterSuite
    @Parameters({"before"})
    public void after(@Optional("suite")String before){
        if(before.equals("suite")) {
            System.out.println("Run After Suite");
            if (driver() != null) {
                driver().quit();
            }
        }
    }

    @AfterTest
    @Parameters({"before"})
    public void afterT(@Optional("")String before){
        if(before.equals("test")) {
            System.out.println("Run After Test");
           // ddd.quit();
            if (driver() != null) {
                driver().quit();
            }


        }
    }


    private void setUpBrowser() {
        WebDriver driver = new ChromeDriver();
        setDRIVER(driver);
        driver().manage().window().setSize(new Dimension(1600, 2000));
    }

}
