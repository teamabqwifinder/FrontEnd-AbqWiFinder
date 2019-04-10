package deepdive.cnm.edu.frontend_abqwifinder.controller;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import deepdive.cnm.edu.frontend_abqwifinder.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

  @Rule
  public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

  @Test
  public void signInButtonTest(){
    onView(withId(R.id.sign_in)).perform(click());
  }


}