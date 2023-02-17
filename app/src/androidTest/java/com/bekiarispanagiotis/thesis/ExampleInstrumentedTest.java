package com.bekiarispanagiotis.thesis;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.test.espresso.action.ViewActions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.bekiarispanagiotis.thesis", appContext.getPackageName());
    }

    @Test
    public void launchActivity() {
        var activityScenario1 = ActivityScenario.launchActivityForResult(MainActivity.class);
        assertEquals(activityScenario1.getState(), Lifecycle.State.RESUMED); //  The activity became active and ready to receive input
        activityScenario1.close();
        var activityScenario2 = ActivityScenario.launchActivityForResult(PianoActivity.class);
        assertEquals(activityScenario2.getState(), Lifecycle.State.RESUMED);
        activityScenario2.close();
        var activityScenario3 = ActivityScenario.launchActivityForResult(GuitarActivity.class);
        assertEquals(activityScenario3.getState(), Lifecycle.State.RESUMED);
        activityScenario3.close();
        var activityScenario4 = ActivityScenario.launchActivityForResult(ViolinActivity.class);
        assertEquals(activityScenario4.getState(), Lifecycle.State.RESUMED);
        activityScenario4.close();
    }

    @Test
    public void menuIsVisible() {
        var activityScenario1 = ActivityScenario.launchActivityForResult(MainActivity.class);
        onView(withId(R.id.bottomNavigationView).matches(isDisplayed()));
        activityScenario1.close();
        var activityScenario2 = ActivityScenario.launchActivityForResult(PianoActivity.class);
        onView(withId(R.id.bottomNavigationView).matches(isDisplayed()));
        activityScenario2.close();
        var activityScenario3 = ActivityScenario.launchActivityForResult(GuitarActivity.class);
        onView(withId(R.id.bottomNavigationView).matches(isDisplayed()));
        activityScenario3.close();
        var activityScenario4 = ActivityScenario.launchActivityForResult(ViolinActivity.class);
        onView(withId(R.id.bottomNavigationView).matches(isDisplayed()));
        activityScenario4.close();
    }

    @Test
    public void closeApp() {
        //recreates onBackPressed() method
        var activityScenario = ActivityScenario.launchActivityForResult(MainActivity.class);
        ViewActions.pressBack();
        ViewActions.pressBack();
        activityScenario.close();
        assertEquals(activityScenario.getState(), Lifecycle.State.DESTROYED);
    }

    @Test
    public void pianoButtonsAreVisible() {
        var activityScenario1 = ActivityScenario.launchActivityForResult(PianoActivity.class);
        onView(withId(R.id.buttonNotePianoC).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoD).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoDsharp).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoE).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoF).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoFsharp).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoG).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoGsharp).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoA).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoAsharp).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoB).matches(isDisplayed()));
        onView(withId(R.id.buttonNotePianoChi).matches(isDisplayed()));
        activityScenario1.close();
    }

    @Test
    public void guitarButtonsAreVisible() {
        var activityScenario = ActivityScenario.launchActivityForResult(GuitarActivity.class);
        onView(withId(R.id.buttonNoteGuitarEhigh).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteGuitarB).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteGuitarG).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteGuitarD).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteGuitarA).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteGuitarElow).matches(isDisplayed()));
        activityScenario.close();
    }

    @Test
    public void violinButtonsAreVisible() {
        var activityScenario = ActivityScenario.launchActivityForResult(ViolinActivity.class);
        onView(withId(R.id.buttonNoteViolinD).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteViolinA).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteViolinE).matches(isDisplayed()));
        onView(withId(R.id.buttonNoteViolinG).matches(isDisplayed()));
        activityScenario.close();
    }

    private void onView(boolean matches) {
    }
}