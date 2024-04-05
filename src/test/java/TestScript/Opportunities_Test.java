package TestScript;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_Utilities.BaseClass;
import generic_Utilities.JavaUtility;
import pom_Repository.AddOrganizationPage;
import pom_Repository.CreateNewOpportunityPage;
import pom_Repository.DeletePage;
import pom_Repository.HomePage;
import pom_Repository.OpportunitiesPage;
import pom_Repository.Validation;

@Listeners(generic_Utilities.ListenersImplementation.class)
public class Opportunities_Test extends BaseClass{
	
	@Test(groups = "SmokeSuite",retryAnalyzer = generic_Utilities.RetryAnalyzerImplementation.class)
	public void test() throws IOException, InterruptedException {
		sutil.screenshot(driver, "validation for HomePage");
		String pageTitle = eutil.ReadDataEx("Opportunity", 2, 0);
		sutil.validation(driver,pageTitle);
		HomePage hp = new HomePage(driver);
		hp.clickOnOpportunities();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickOnAddOpportunities();
		JavaUtility j = new JavaUtility();
		sutil.screenshot(driver, "validation for New Opportunity Page "+j.getDate());
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
		//Assert.fail();
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
