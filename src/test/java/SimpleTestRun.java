import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleTestRun extends BrowserFactory {
    private String search = "";
    @Parameters({"myGreatProperty"})
    @Test
    public void go(@Optional("Hello darkness my old friend")String myGreatProperty) throws InterruptedException {
        driver().get("https://google.com");
        System.out.println("------------------");
        System.out.println(myGreatProperty);
        search = myGreatProperty;
        System.out.println("------------------");
        driver().findElement(By.cssSelector("[name='q']")).sendKeys(myGreatProperty);
        driver().findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);

    }

    @Test(dependsOnMethods = "go")
    public void afterGo() throws InterruptedException {
        System.out.println("++++++");
        System.out.println(driver().getTitle());
        System.out.println("++++++");
        Thread.sleep(1000);
        Assert.assertTrue(driver().getTitle().contains(search));
    }


}
