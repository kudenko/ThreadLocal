import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public abstract class SearchString extends BrowserFactory {

    public abstract String getSearch();

    @Test
    public void go() throws InterruptedException {
        //ddd.get("https://google.com");

        driver().get("https://google.com");
        System.out.println("------------------");
        System.out.println(getSearch());
        System.out.println("------------------");
        Thread.sleep(4000);

//        ddd.findElement(By.cssSelector("[name='q']")).sendKeys(getSearch());
//        ddd.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
        driver().findElement(By.cssSelector("[name='q']")).sendKeys(getSearch());
        driver().findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
        System.out.println("-----title----");
//      System.out.println(ddd.getTitle());
//      System.out.println(driver().getTitle());
        System.out.println("-----title----");

        Thread.sleep(3000);
    }
}
