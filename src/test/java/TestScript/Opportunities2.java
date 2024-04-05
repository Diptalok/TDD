package TestScript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_Utilities.BaseClass;
import pom_Repository.AddOrganizationPage;
import pom_Repository.CreateNewOpportunityPage;
import pom_Repository.DeletePage;
import pom_Repository.HomePage;
import pom_Repository.OpportunitiesPage;
import pom_Repository.Validation;

@Test
public class Opportunities2 extends BaseClass{
	
	@Test
	public void test() throws IOException, InterruptedException {
		sutil.screenshot(driver, "validation for HomePage");
		HomePage hp = new HomePage(driver);
		hp.clickOnOpportunities();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickOnAddOpportunities();
		sutil.screenshot(driver, "validation for New Opportunity Page");
		CreateNewOpportunityPage cop = new CreateNewOpportunityPage(driver);
		String OppotunityName = eutil.ReadDataEx("Opportunity", 1, 0);
		cop.clickOnAddOpportunities(OppotunityName);
		cop.clickOnAddRelatedTo();
		sutil.switchingWindow(driver);
		AddOrganizationPage aop = new AddOrganizationPage(driver);
		aop.clickOnOrganizationName();
		sutil.switchingMainWindow(driver);
		String OppType = eutil.ReadDataEx("Opportunity", 1, 1);
		WebElement OpportunityType = cop.getOpportunityType();
		sutil.dropDownHandling(OpportunityType,OppType);
		cop.clickOnSave();
		sutil.screenshot(driver, "validation for New Opportunity creation");
		Validation valid = new Validation(driver);
		valid.validation(OppotunityName);
		sutil.back(driver);
		DeletePage dp = new DeletePage(driver);
		dp.clickOnCheckBox();
		dp.clickOnDelete();
		sutil.alertHanlding(driver);
		sutil.screenshot(driver, "validation for Deletion");
			
	}

}
