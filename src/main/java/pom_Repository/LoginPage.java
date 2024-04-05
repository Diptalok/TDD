package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "user_name") private WebElement username_edt;
	@FindBy(name = "user_password") private WebElement password_edt;
	@FindBy(id="submitButton") private WebElement login_btn;
	
	public void logInToApp(String user, String pass) {
		username_edt.sendKeys(user);
		password_edt.sendKeys(pass);
		login_btn.click();
	}

}
