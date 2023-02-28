package com.bekiarispanagiotis.thesis;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
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
    public void closeApp() {
        //recreates onBackPressed() method
        var activityScenario = ActivityScenario.launchActivityForResult(MainActivity.class);
        ViewActions.pressBack();
        ViewActions.pressBack();
        activityScenario.close();
        assertEquals(activityScenario.getState(), Lifecycle.State.DESTROYED);
    }

    @Test
    public void menuClick() {
        var activityScenario = ActivityScenario.launchActivityForResult(MainActivity.class);
        onView(withId(R.id.piano)).perform(click());
        onView(withId(R.id.guitar)).perform(click());
        onView(withId(R.id.violin)).perform(click());
        onView(withId(R.id.guitar)).perform(click());
        onView(withId(R.id.piano)).perform(click());
        onView(withId(R.id.home)).perform(click());
        activityScenario.close();
    }
    @Test
    public void pianoButtonsArePlayable() {
        var activityScenarioP = ActivityScenario.launchActivityForResult(PianoActivity.class);
        onView(withId(R.id.buttonNotePianoC)).perform(click());
        onView(withId(R.id.buttonNotePianoCsharp)).perform(click());
        onView(withId(R.id.buttonNotePianoD)).perform(click());
        onView(withId(R.id.buttonNotePianoDsharp)).perform(click());
        onView(withId(R.id.buttonNotePianoE)).perform(click());
        onView(withId(R.id.buttonNotePianoF)).perform(click());
        onView(withId(R.id.buttonNotePianoFsharp)).perform(click());
        onView(withId(R.id.buttonNotePianoG)).perform(click());
        onView(withId(R.id.buttonNotePianoGsharp)).perform(click());
        onView(withId(R.id.buttonNotePianoA)).perform(click());
        onView(withId(R.id.buttonNotePianoAsharp)).perform(click());
        onView(withId(R.id.buttonNotePianoB)).perform(click());
        onView(withId(R.id.buttonNotePianoChi)).perform(click());
        activityScenarioP.close();
    }

    @Test
    public void guitarButtonsArePlayable() {
        var activityScenario = ActivityScenario.launchActivityForResult(GuitarActivity.class);
        onView(withId(R.id.buttonNoteGuitarEhigh)).perform(click());
        onView(withId(R.id.buttonNoteGuitarB)).perform(click());
        onView(withId(R.id.buttonNoteGuitarG)).perform(click());
        onView(withId(R.id.buttonNoteGuitarD)).perform(click());
        onView(withId(R.id.buttonNoteGuitarA)).perform(click());
        onView(withId(R.id.buttonNoteGuitarElow)).perform(click());
        activityScenario.close();
    }

    @Test
    public void violinButtonsArePlayable() {
        var activityScenario = ActivityScenario.launchActivityForResult(ViolinActivity.class);
        onView(withId(R.id.buttonNoteViolinD)).perform(click());
        onView(withId(R.id.buttonNoteViolinA)).perform(click());
        onView(withId(R.id.buttonNoteViolinE)).perform(click());
        onView(withId(R.id.buttonNoteViolinG)).perform(click());
        activityScenario.close();
    }

}