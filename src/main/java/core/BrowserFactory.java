package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BrowserFactory extends CurrentSession{

    static WebDriver driver;


    //public static WebDriver ddd;

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
        //ddd = new ChromeDriver();
    }

    @AfterSuite
    @Parameters({"before"})
    public void after(@Optional("suite")String before){
        if(before.equals("suite")) {
            System.out.println("Run After Suite");
           tearDown();
        }
    }

    @AfterTest
    @Parameters({"before"})
    public void afterT(@Optional("")String before){
        if(before.equals("test")) {
            System.out.println("Run After Test");
        }
        tearDown();
    }


    private void setUpBrowser() {
        driver = new ChromeDriver();
        setDRIVER(driver);
        driver().manage().window().setSize(new Dimension(1600, 2000));
    }

    private void tearDown(){
        // ddd.quit();
        if (driver() != null) {
            driver().quit();
        }
    }

}
