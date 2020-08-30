package com.nus.iss.gof.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;;import java.util.concurrent.TimeUnit;

public class StepDefs {

    WebDriver driver;
    Scenario s;
    String url_create_travel_plan = "http://localhost:4200/FormCreation";

    @Before
    public void before(Scenario s){
        this.s = s;
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        System.setProperty("webdriver.chrome.driver","chromedriver_linux");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        s.write("Chrome Browser invoked");
        s.write("User is logged in is to be implemented*************");
        throw new cucumber.api.PendingException();
    }

    @Given("User is on {string} Page")
    public void user_is_on_Page(String string) throws Exception {
        if (string.equalsIgnoreCase("Create Travel Plan")){
            driver.get(url_create_travel_plan);
        }else{
            throw new Exception("Page Url not defined yet. ");
        }
    }

    @Given("User clicked on add first Travel leg link")
    public void user_clicked_on_add_first_Travel_leg_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("User filled the form details as below")
    public void user_filled_the_form_details_as_below() {

        driver.findElement(By.xpath("//input[@placeholder='Set a title for your trip']")).sendKeys("MyFirst Trip");
        driver.findElement(By.xpath("//textarea[@placeholder='Enter a description']")).sendKeys("Trip Descp");
        driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Akash");
        driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys("Tyagi");
        driver.findElement(By.xpath("//input[@placeholder='Travelling From']")).sendKeys("Sing");
        driver.findElement(By.xpath("//input[@placeholder='Travelling To']")).sendKeys("NZ");
        //driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")).sendKeys("MyFirst Trip");

    }

    @When("click on save button")
    public void click_on_save_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("User sees the success message and travel details are saved successfully")
    public void user_sees_the_success_message_and_travel_details_are_saved_successfully() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new Exception("Validation step is failing, app needs to display a success message");
    }

}
