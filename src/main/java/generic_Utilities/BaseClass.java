package generic_Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pom_Repository.HomePage;
import pom_Repository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public SeleniumUtilities sutil = new SeleniumUtilities();
	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite(groups = "SmokeSuite")
	public void DBconnection() {
		System.out.println("DB Connection successful");
	}
	
	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(/*String BROWSER*/) {
		driver = new ChromeDriver();
		/*if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("FireFox")) {
			driver = new FirefoxDriver();
		}*/
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver);
		System.out.println("Browser Launch successful");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void logInToApp() throws Exception {
		String URL = putil.ReadDataProp("url");
		String USERNAME = putil.ReadDataProp("username");
		String PASSWORD = putil.ReadDataProp("password");
		driver.get(URL);
		sDriver=driver;
		sutil.screenshot(driver, "validation for LogIn");
		LoginPage lp = new LoginPage(driver);
		lp.logInToApp(USERNAME, PASSWORD);
		System.out.println("Log in successful");
	}
	
	@AfterMethod(alwaysRun = true)
	public void signOut() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		WebElement adminstrator = hp.getAdminstrator();
		sutil.mouseHover(driver,adminstrator);
		System.out.println("Sign out successful");
	}
	
	@AfterClass(alwaysRun = true)
	public void browserClose()  {
		driver.quit();
		System.out.println("Browser clousure successful");
	}
	
	@AfterSuite(alwaysRun = true)
	public void DBclose() {
		System.out.println("DB Connection closed");
	}

}
