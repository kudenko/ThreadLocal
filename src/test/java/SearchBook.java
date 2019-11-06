import org.testng.Assert;

public class SearchBook extends SearchString {
    @Override
    public String getSearch() {
        return "Book";
    }

    @Override
    public void go() throws InterruptedException {
        Assert.fail("FAIL!!!!!");
        //Thread.sleep(5000);
    }

}
