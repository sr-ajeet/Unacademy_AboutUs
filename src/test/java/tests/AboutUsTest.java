package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.ExtentTestNGListener;
import pages.Display_Page;

@Listeners(ExtentTestNGListener.class)
public class AboutUsTest extends BaseTest {

    private Display_Page aboutPage;

    @BeforeMethod
    public void beforeMethod() throws IOException {

        setup();

        aboutPage = new Display_Page(driver);

        ExtentTestNGListener.logStep(
                "Browser launched successfully");

        ExtentTestNGListener.logStep(
                "Application URL opened");
    }

    @AfterMethod
    public void afterMethod() throws IOException {

        ExtentTestNGListener.logStep(
                "Closing browser");

        tearDown();
    }

    @Test(priority = 1,
    description = "TC047 - Validate that the About Us page displays company information, mission, and services correctly")
    public void validateAboutUsPageContent() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Verify About Us page title is displayed");

        Assert.assertTrue(
                aboutPage.istitledisplayed(),
                "About Us page content is not displayed correctly");

        ExtentTestNGListener.logPassStep(
                "About Us page content validated successfully");
    }

    @Test(priority = 2,
    description = "TC048 - Validate About Us page responsiveness across desktop, tablet, and mobile viewports")
    public void validateAboutUsResponsiveness() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Validate page responsiveness on desktop, tablet and mobile");

        Assert.assertTrue(
                aboutPage.isResponsive(),
                "About Us page is not responsive across different screen sizes");

        ExtentTestNGListener.logPassStep(
                "About Us page responsiveness validated successfully");
    }

    @Test(priority = 3,
    description = "TC049 - Validate About Us page load performance meets acceptable response time")
    public void validateAboutUsPerformance() {

        ExtentTestNGListener.logStep(
                "Start page load timer");

        long startTime =
                System.currentTimeMillis();

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Verify page loaded successfully");

        Assert.assertTrue(
                aboutPage.istitledisplayed(),
                "About Us page failed to load");

        long loadTime =
                System.currentTimeMillis()
                        - startTime;

        ExtentTestNGListener.logStep(
                "Actual page load time : "
                        + loadTime + " ms");

        Assert.assertTrue(
                loadTime < 5000,
                "About Us page took more than 5 seconds to load");

        ExtentTestNGListener.logPassStep(
                "Performance validation completed successfully");
    }

    @Test(priority = 4,
    description = "TC050 - Validate Mission and Vision section is displayed with correct content")
    public void validateMissionAndVisionSection() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Verify Mission and Vision section");

        Assert.assertTrue(
                aboutPage.isMissionVisionDisplayed(),
                "Mission and Vision section is not displayed");

        ExtentTestNGListener.logPassStep(
                "Mission and Vision section validated successfully");
    }

    @Test(priority = 5,
    description = "TC051 - Validate Company Achievements section is displayed successfully")
    public void validateAchievementsSection() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Verify Company Achievements section");

        Assert.assertTrue(
                aboutPage.isAchievementsDisplayed(),
                "Company Achievements section is not displayed");

        ExtentTestNGListener.logPassStep(
                "Achievements section validated successfully");
    }

    @Test(priority = 6,
    description = "TC052 - Validate Current Openings section displays available job opportunities")
    public void validateCurrentOpeningsSection() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Open Current Openings section");

        aboutPage.clickOpenPositions();

        ExtentTestNGListener.logStep(
                "Open View All Job Openings page");

        aboutPage.clickSeeAllOpenings();

        ExtentTestNGListener.logStep(
                "Click Open Jobs button");

        aboutPage.clickgetAllOpenings();

        ExtentTestNGListener.logStep(
                "Verify available jobs are displayed");

        Assert.assertTrue(
                aboutPage.areJobsdisplayed(),
                "Current job openings are not displayed");

        ExtentTestNGListener.logPassStep(
                "Current Openings section validated successfully");
    }

    @Test(priority = 7,
    description = "TC053 - Validate Apply action redirects the user to the job application page")
    public void validateJobApplicationRedirection() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Open Current Openings section");

        aboutPage.clickOpenPositions();

        ExtentTestNGListener.logStep(
                "Navigate to all job openings");

        aboutPage.clickSeeAllOpenings();

        ExtentTestNGListener.logStep(
                "Click Open Jobs button");

        aboutPage.clickgetAllOpenings();
        
        ExtentTestNGListener.logStep(
                "Click View And Apply button");

        aboutPage.clickViewAndApply();

        ExtentTestNGListener.logStep(
                "Verify job application page redirection");

        Assert.assertTrue(
                aboutPage.areJobsdisplayed(),
                "User was not redirected to the job application page");

        ExtentTestNGListener.logPassStep(
                "Job application redirection validated successfully");
    }

    @Test(priority = 8,
    description = "TC054 - Validate contact information including email, phone number, and address is displayed")
    public void validateContactInformation() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Verify contact information");

        Assert.assertTrue(
                aboutPage.contactinfodisplayed(),
                "Contact information is not displayed");

        ExtentTestNGListener.logPassStep(
                "Contact information validated successfully");
    }

    @Test(priority = 9,
    description = "TC055 - Validate email link is visible and accessible to the user")
    public void validateEmailLink() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Verify email link");

        Assert.assertTrue(
                aboutPage.isEmailLinkDisplayed(),
                "Email link is not displayed");

        ExtentTestNGListener.logPassStep(
                "Email link validated successfully");
    }

    @Test(priority = 10,
    description = "TC056 - Validate social media links redirect users to official platform pages")
    public void validateSocialMediaLinks() {

        ExtentTestNGListener.logStep(
                "Navigate to About Us page");

        aboutPage.clickabout();

        ExtentTestNGListener.logStep(
                "Verify Facebook, LinkedIn and YouTube links");

        Assert.assertTrue(
                aboutPage.areSocialMediaLinksDisplayed(),
                "Social media links are not displayed");

        ExtentTestNGListener.logPassStep(
                "Social media links validated successfully");
    }
}