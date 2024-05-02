package org.stepdef;

import org.pom.FpPojo;
import org.sample.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FpPage extends BaseClass {
	
	@Given("To launch the browser and max the window")
	public void to_launch_the_browser_and_max_the_window() {
		browserLaunch();
		maxBrowser();
	   
	}

	@When("To launch the url of the given application")
	public void to_launch_the_url_of_the_given_application() {
		loadUrl("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");
	   
	}

	@When("To pass the invalid username in username field")
	public void to_pass_the_invalid_username_in_username_field() {
		FpPojo  f = new FpPojo();
		passText(f.getFpBtn(), "aniparu122@gamil.com");
	   
	}

	@When("To click search button")
	public void to_click_search_button() {
		FpPojo  f = new FpPojo();
		btnClick(f.getSearchEmail());
	   
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeTheBrowser();
	   
	}



}
