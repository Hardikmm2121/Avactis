package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {

	static TakesScreenshot ts;
	
	public static void takeScreenShot(WebDriver driver,String path) throws IOException {
		
		ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File(path));
	
	}
	
}
