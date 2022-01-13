import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopTests extends BaseTest {

    @Test
    public void checkTitle() {
        driver.get("http://sampleshop.inqa.pl/");
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        String expectedTitle = "Automation Sample Shop";

        Assert.assertEquals(title, expectedTitle);
    }
}
