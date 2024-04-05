package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[contains(@alt,\"Cr\")]") private WebElement AddOpportunities;
	public void clickOnAddOpportunities() {
		AddOpportunities.click();
	}

}
