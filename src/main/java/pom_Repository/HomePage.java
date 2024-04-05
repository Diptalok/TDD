package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Opportunities") private WebElement Opportunities;
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement Adminstrator;
	@FindBy(linkText = "Sign Out") private WebElement Signout;
	
	public void clickOnOpportunities() {
		Opportunities.click();
	}
	public WebElement getAdminstrator() {
		return Adminstrator;
	}
	public void SignOut() {
		Signout.click();
	}

}
