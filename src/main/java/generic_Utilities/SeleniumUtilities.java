package generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeleniumUtilities {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void mouseHover(WebDriver driver, WebElement element) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(3000);
	}

	public void switchingWindow(WebDriver driver) {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String window : windowIDs) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title=="") {
				break;
			}
		}
	}

	public void switchingMainWindow(WebDriver driver) {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String window : windowIDs) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if (title.equals("Adminstrator - Opportunities - vtiger CRM 5 - Commercial Open Source CRM")) {
				break;
			}
		}
	}
	public void back(WebDriver driver) {
		for(int i =1;i<3;i++) {
			driver.navigate().back();
		}
	}
	public void dropDownHandling(WebElement element, String type) {
		Select se = new Select(element);
		se.selectByVisibleText(type);
	}
	public void alertHanlding(WebDriver driver) throws InterruptedException {
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}
	public String screenshot(WebDriver driver,String screenshot) throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+screenshot+".png");
		FileUtils.copyFile(src, dest);
		Thread.sleep(4000);
		return dest.getAbsolutePath();
		
	}
	public void validation(WebDriver driver,String ExpTitle ) {
		String orgTitle = driver.getTitle();
		Assert.assertEquals(orgTitle, ExpTitle);
	}

}
