package algonquin.cst2335.li000848;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass")));
    }

    @Test
    public void testFindMissingDigit() {
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("Password#$*"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass")));
    }

    @Test
    public void testFindMissingLowerCase() {
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("PASSWORD123#$*"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass")));
    }

    @Test
    public void testFindMissingSpecialCharacter() {
        //find the view
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        //type in password123#$*
        appCompatEditText.perform(replaceText("Password123"));

        //find the button
        ViewInteraction materialButton = onView(withId(R.id.button));
        //click the button
        materialButton.perform(click());

        //find the text view
        ViewInteraction textView = onView(withId(R.id.textView));
        //check the text
        textView.check(matches(withText("You shall not pass")));
    }

    @Test
    public void testFindMissingUpperCase() {
        ViewInteraction appCompatEditText = onView(withId(R.id.editText));
        appCompatEditText.perform(replaceText("password123#$*"));

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass")));
    }
}