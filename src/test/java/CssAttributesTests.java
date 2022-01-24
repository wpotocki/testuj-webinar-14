import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssAttributesTests extends BaseTest {
    private static WebElement modalAd;
    private static WebElement modalAdTitleBar;

    @Test
    public void modalAdIsDisplayed() {
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        modalAd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        modalAdTitleBar = modalAd.findElement(By.className("modal-title"));

        Assert.assertTrue(modalAd.isDisplayed());
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHeaderFontIsOpenSansTests() {
        String fontFamily = modalAdTitleBar.getCssValue("font-family");
        Assert.assertTrue(fontFamily.contains("Open Sans"));
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHeaderFontColorIsWhiteTest() {
        String fontColor = modalAdTitleBar.getCssValue("color");
        // zamiana koloru rgba na hex
        String fontColorHex = Color.fromString(fontColor).asHex();

        Assert.assertEquals(fontColorHex, "#ffffff");
    }
}
