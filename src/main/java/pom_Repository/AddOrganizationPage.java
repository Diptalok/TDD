package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOrganizationPage {
	public AddOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "DS Solutions") private WebElement OrganizationName;
	public void clickOnOrganizationName() {
		OrganizationName.click();
	}

}
