package com.mytaxi.android_demo.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import com.mytaxi.android_demo.activities.AuthenticationActivity;
import com.mytaxi.android_demo.page.HomepageActivity;
import com.mytaxi.android_demo.page.LoginActivity;
import org.junit.Rule;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static junit.framework.Assert.assertNotNull;

public class LoginActivitySteps {

    @Rule
    public ActivityTestRule<AuthenticationActivity> activityTestRule = new ActivityTestRule<>(AuthenticationActivity.class);

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    private Activity activity;

    private LoginActivity login = new LoginActivity();

    @Before("@login-feature")
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
    }

    @After("@login-feature")
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @Given("^I am on login screen")
    public void I_am_on_login_screen() {
        assertNotNull(activity);
    }

    @When("^I input username (\\S+)$")
    public void I_input_edt_username(final String edt_username) {
        login.setUsername(edt_username);
    }

    @When("^I input password \"(.*?)\"$")
    public void I_input_edt_password(final String edt_password) {
        login.setPassword(edt_password);
    }

    @When("^I press submit button$")
    public void I_press_btn_login_button() {
        login.clickLogin();
    }

    @Then("^I should see error")
    public void I_should_see_error() {
        login.verifyLoginFail();
    }

    @Then("^I should see homepage")
    public void I_should_see_homepage() {
        login.verifyLoginSuccess();
    }

}