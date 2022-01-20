import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class IFrameTests extends BaseTest {

    @Test
    public void checkTextInIframe() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        // Sprawdzenie czy zawiera nagłówek h3 tekst TinyMCE WYSIWYG
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("TinyMCE WYSIWYG"));

        // pobranie ramki
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));

        // pobranie wszystkich ramek
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));

        // przełączenie na ramkę
        driver.switchTo().frame(iframe);

        // sprawdzenie / pobranie elementu wewnątrz ramki
        Assert.assertNotNull(driver.findElement(By.id("tinymce")));

        // przejście do rodzica dla ramki
        driver.switchTo().parentFrame();

        // przejście do głównego obszaru (kontekstu)
        driver.switchTo().defaultContent();

        // sprawdzenie / pobranie elementu z głównego kontekstu
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("TinyMCE WYSIWYG"));
    }
}
