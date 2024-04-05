package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {
	public DeletePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "selected_id") private WebElement CheckBox;
	@FindBy(xpath="//input[@value=\"Delete\"]") private WebElement Delete;
	public void clickOnCheckBox() {
		CheckBox.click();
	}
	public void clickOnDelete() {
		Delete.click();
	}

}
