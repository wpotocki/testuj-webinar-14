import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WindowTests extends BaseTest {

    @Test
    public void multipleWindowsTests() {
        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindowHandle = driver.getWindowHandles();

        allWindowHandle.forEach(windowElement -> {
            if(!windowElement.equals(mainWindow)) {
                driver.switchTo().window(windowElement);
            }
        });


        // konwersja set do listy na trzy sposoby

        List<String> list = new LinkedList<>(allWindowHandle);

        List<String> list2 = new LinkedList<>();
        list2.addAll(allWindowHandle);

        // od Java 8 w górę
        List<String> list3 = allWindowHandle.stream().collect(Collectors.toList());

//        for (String windowElement : allWindowHandle) {
//            if(!windowElement.equals(mainWindow)) {
//                driver.switchTo().window(windowElement);
//            }
//        }

        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("New Window"));
        driver.close();
        driver.switchTo().window(mainWindow);

        Assert.assertNotNull(driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")));
    }
}
