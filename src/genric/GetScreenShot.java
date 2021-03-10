package genric;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {
	public static String getImage(WebDriver driver,String testCaseName ) {
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		String filePath=IAutoConstants.IMAGE_PATH+timeStamp+testCaseName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File tempFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(filePath);
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

}
