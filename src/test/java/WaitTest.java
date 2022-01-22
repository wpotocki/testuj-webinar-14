import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest extends BaseTest {

    @Test
    public void progressBarTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();

        WebDriverWait waitForFinish = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForFinish.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish")));


        String finishText = driver.findElement(By.id("finish")).getText();
        Assert.assertEquals(finishText, "Hello World!");
    }

    @Test
    public void progressBarFluentWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();

        FluentWait<WebDriver> waitForFinish = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        waitForFinish.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish")));


        String finishText = driver.findElement(By.id("finish")).getText();
        Assert.assertEquals(finishText, "Hello World!");
    }
}
