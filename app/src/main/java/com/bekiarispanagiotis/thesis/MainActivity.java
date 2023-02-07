package com.bekiarispanagiotis.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private View maxView;
    BottomNavigationView bottomNavigationView;
    private boolean isBackPressedOnce = false;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);

        maxView = getWindow().getDecorView();
        maxView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                maxView.setSystemUiVisibility(fullScreenView());
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    return true;
                case R.id.piano:
                    startActivity(new Intent(getApplicationContext(),PianoActivity.class));
                    overridePendingTransition(R.anim.animright,0);
                    finish();
                    return true;
                case R.id.guitar:
                    startActivity(new Intent(getApplicationContext(),GuitarActivity.class));
                    overridePendingTransition(R.anim.animright,0);
                    finish();
                    return true;
                case R.id.violin:
                    startActivity(new Intent(getApplicationContext(),ViolinActivity.class));
                    overridePendingTransition(R.anim.animright,0);
                    finish();
                    return true;
            }
            return false;
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            maxView.setSystemUiVisibility(fullScreenView());
        }
    }

    private int fullScreenView() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    public void onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed();
            return;
        }
        Toast.makeText(this,"Tap again to exit", Toast.LENGTH_SHORT).show();
        isBackPressedOnce = true;

        new Handler().postDelayed(() -> isBackPressedOnce = false, 2000);
    }

}