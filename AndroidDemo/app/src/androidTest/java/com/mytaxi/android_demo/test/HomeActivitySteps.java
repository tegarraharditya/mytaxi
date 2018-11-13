package com.mytaxi.android_demo.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.page.HomepageActivity;

import org.junit.Rule;

import java.util.concurrent.TimeUnit;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;

public class HomeActivitySteps {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    private GrantPermissionRule permissionRule  = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

    private Activity activity;

    private HomepageActivity home = new HomepageActivity();

    @Before("@search-feature")
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
    }

    @After("@search-feature")
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @Given("^I am on homepage")
    public void I_am_on_homepage() {
        home.verifySearchBar();
    }

    @And("^I search \"(.*?)\"$")
    public void I_should_search(final String driverName) {
        home.typeSearchDriver(driverName);
    }

    @And("^I choose \"(.*?)\"$")
    public void I_choose(final String choosendriverName) {
        onView(isRoot()).perform(BaseUtil.waitForSecond(TimeUnit.SECONDS.toMillis(1)));
        clickChoosenDriver(choosendriverName,activity);
    }

    private void clickChoosenDriver(final String choosenDriverName, Activity activity){
        home.chooseDriver(choosenDriverName,activity);
    }
}
