package com.bekiarispanagiotis.thesis;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
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
}