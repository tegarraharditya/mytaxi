package com.mytaxi.android_demo.page;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.test.BaseUtil;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.R.id;
import static com.mytaxi.android_demo.R.string;


public class LoginActivity extends Activity {
    private EditText usernameEditText, passwordEditText;
    private View errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_authentication);

        usernameEditText = findViewById(R.id.edt_username);
        passwordEditText = findViewById(id.edt_password);
    }


    public void setUsername(String edt_username) {
        onView(withId(R.id.edt_username)).perform(typeText(edt_username),closeSoftKeyboard());
    }

    public void setPassword(String edt_password) {
        onView(withId(id.edt_password)).perform(typeText(edt_password),closeSoftKeyboard());
    }

    public void clickLogin() {
        onView(withId(id.btn_login)).perform(click());
    }

    public void verifyLoginFail(){
        onView(isRoot()).perform(BaseUtil.waitForSecond(TimeUnit.SECONDS.toMillis(3)));
        onView(withId(id.textSearch)).check(doesNotExist());
        onView(withText(string.message_login_fail)).check(matches(isDisplayed()));
    }

    public void verifyLoginSuccess() {
        onView(withId(id.textSearch)).check(doesNotExist());
    }

}