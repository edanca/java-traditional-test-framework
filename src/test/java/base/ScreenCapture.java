package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenCapture {

    public static String recordFailure(WebDriver driver, String name) {
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        String screenshotDirPath = "src/main/resources/screenshots/";
        String testScreenshotPath = screenshotDirPath + getCurrentTime();
        try {
            File directory = new File(testScreenshotPath);
            directory.mkdir();
            Files.move(screenshot, new File(testScreenshotPath + "/" + name));
            String absPath = directory.getAbsolutePath() + "/" + name;
            return absPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getCurrentTime() {
        LocalDateTime dt = java.time.LocalDateTime.now();
        return dt.toString();
    }
}
