package com.mytaxi.android_demo.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.test.BaseUtil;

import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.R.id;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;


public class HomepageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Intent intent = new Intent(HomepageActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void verifySearchBar(){
        onView(isRoot()).perform(BaseUtil.waitForSecond(TimeUnit.SECONDS.toMillis(1)));
        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
    }

    public void typeSearchDriver(final String driverName){
        onView(isRoot()).perform(BaseUtil.waitForSecond(TimeUnit.SECONDS.toMillis(1)));
        onView(withId(id.textSearch)).perform(typeText(driverName), closeSoftKeyboard());
    }

    public void chooseDriver(final String choosendriverName, Activity activity){
        onView(isRoot()).perform(BaseUtil.waitForSecond(TimeUnit.SECONDS.toMillis(1)));
        onView(withText(choosendriverName))
                .inRoot(withDecorView(not(Matchers.is(activity.getWindow().getDecorView()))))
                .perform(click());
        onView(withId(id.textViewDriverName)).check(matches(withText(equalToIgnoringCase(choosendriverName))));
    }
}
