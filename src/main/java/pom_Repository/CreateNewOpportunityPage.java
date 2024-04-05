package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOpportunityPage {
	public CreateNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="potentialname") private WebElement OpportunityName;
	@FindBy(name="opportunity_type") private WebElement OpportunityType;
	@FindBy(xpath="(//img[@alt=\"Select\"])[1]") private WebElement AddRelatedTo;
	@FindBy(xpath="(//input[@type=\"submit\"])[1]") private WebElement Save;
	
	public void clickOnAddOpportunities(String name) {
		OpportunityName.sendKeys(name);
	}
	public WebElement getOpportunityType() {
		return OpportunityType;
	}
	public void clickOnAddRelatedTo() {
		AddRelatedTo.click();
	}
	public void clickOnSave() {
		Save.click();
	}
	

}