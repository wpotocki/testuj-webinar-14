package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        // rzutowanie / konwersja typu, czyli zamiana WebDriver na TakesScreenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        // wykonaie zrzutu ekranu
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // stworzenie docelowego pliku, w którym będzie umieszczony zrzut ekranu
        File destinationFile = new File(System.getProperty("user.dir") + "/target/" + fileName);

        try {
            FileUtils.copyFile(screenshot, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
