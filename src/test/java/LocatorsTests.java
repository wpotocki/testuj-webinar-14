import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocatorsTests extends BaseTest {

    @Test
    public void textExample() {
        driver.get("http://sampleshop.inqa.pl/");

        WebElement elementLink = driver.findElement(By.linkText("Kontakt z nami"));
        WebElement elementPartial = driver.findElement(By.partialLinkText("Kontakt"));

        WebElement fullXpathElement = driver.findElement(By.xpath("/html/body/main/footer/div[2]/div/div[1]/div[1]/div/div[2]/ul/li[6]/a"));
        WebElement xpathElement = driver.findElement(By.xpath("//*[@id=\"link-static-page-contact-2\"]"));
    }

    @Test
    public void classNameExample() {
        driver.get("http://sampleshop.inqa.pl/");

        WebElement element = driver.findElement(By.className("cart-products-count"));
        WebElement element2 = driver.findElement(By.cssSelector(".blockcart .cart-preview .inactive"));
        String actualCount = element.getText();

        Assert.assertEquals(actualCount, "{0}");
    }

    @Test
    public void properCredentialsLoginTest() {
        driver.get("http://the-internet.herokuapp.com/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement successAlert = driver.findElement(By.id("flash"));
        String successText = successAlert.getText();

        Assert.assertTrue(successText.contains("You logged into a secure area!"));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofHours(30));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("xyz")));
    }
}
