package com.example.wordcounter;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.MediumTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

@MediumTest
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void TestCountWords() {
        ViewInteraction textInput = onView(withId(R.id.inputText));
        textInput.perform(replaceText("Hello, this is a test"));

        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("5")));
    }

    @Test
    public void TestCountChars() {
        ViewInteraction textInput = onView(withId(R.id.inputText));
        textInput.perform(replaceText("Hello, this is a test"));

        onView(withId(R.id.spinnerWtc)).perform(click());
        onData(allOf(is(instanceOf(String.class)))).atPosition(1).perform(click());

        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResult)).check(matches(withText("21")));
    }
}
