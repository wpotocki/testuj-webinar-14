import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RadioButtonTests  extends BaseTest {

    @Test
    public void thereAreThreeRadioButtonInFormTests() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        List<WebElement> radioButtons = driver.findElements(By.name("gender"));

        Assert.assertEquals(radioButtons.size(), 3);
    }

    @Test
    public void selectFemaleAndAssertOthersAreNotSelectedTests() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement femaleRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='radio'][value='female']")));

        femaleRadio.click();
        List<WebElement> selectedRadioButtons = driver.findElements(By.cssSelector("input[type=radio]:checked"));

        Assert.assertEquals(selectedRadioButtons.size(), 1);
        Assert.assertEquals(selectedRadioButtons.get(0).getAttribute("value"), "female");
    }
}
