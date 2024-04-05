package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation {
	public Validation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(.,\"[\")]") private WebElement OpportunityInformation;
	public void validation(String OppotunityName) {
		String OpportunityInfo = OpportunityInformation.getText();
		if(OpportunityInfo.contains(OppotunityName)) {
			System.out.println("Test case is passed");
		}
	}

}
