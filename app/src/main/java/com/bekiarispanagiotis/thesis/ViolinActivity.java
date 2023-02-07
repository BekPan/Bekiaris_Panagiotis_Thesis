package com.bekiarispanagiotis.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ViolinActivity extends AppCompatActivity implements View.OnClickListener{

    private View maxView;
    BottomNavigationView bottomNavigationView;
    private boolean isBackPressedOnce = false;

    private SoundPool violinPool;
    private int soundA, soundD, soundE, soundG;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_violin);

        maxView = getWindow().getDecorView();
        maxView.setOnSystemUiVisibilityChangeListener(visibility -> {
            if (visibility == 0)
                maxView.setSystemUiVisibility(fullScreenView());
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.violin);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    overridePendingTransition(R.anim.animleft,0);
                    finish();
                    return true;
                case R.id.piano:
                    startActivity(new Intent(getApplicationContext(),PianoActivity.class));
                    overridePendingTransition(R.anim.animleft,0);
                    finish();
                    return true;
                case R.id.guitar:
                    startActivity(new Intent(getApplicationContext(),GuitarActivity.class));
                    overridePendingTransition(R.anim.animleft,0);
                    finish();
                    return true;
                case R.id.violin:
                    return true;
            }
            return false;
        });
        //load sounds to cache
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        violinPool = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioAttributes)
                .build();

        soundA = violinPool.load(this,R.raw.violin_a,1);
        soundD = violinPool.load(this,R.raw.violin_d,1);
        soundE = violinPool.load(this,R.raw.violin_e,1);
        soundG = violinPool.load(this,R.raw.violin_g,1);

        Button buttonA = findViewById(R.id.buttonNoteViolinA);
        Button buttonD = findViewById(R.id.buttonNoteViolinD);
        Button buttonE = findViewById(R.id.buttonNoteViolinE);
        Button buttonG = findViewById(R.id.buttonNoteViolinG);

        buttonA.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonG.setOnClickListener(this);
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonNoteViolinA:
                //play sound from button
                violinPool.play(soundA,1,1,0,0,1);
                break;
            case R.id.buttonNoteViolinD:
                violinPool.play(soundD,1,1,0,0,1);
                break;
            case R.id.buttonNoteViolinE:
                violinPool.play(soundE,1,1,0,0,1);
                break;
            case R.id.buttonNoteViolinG:
                violinPool.play(soundG,1,1,0,0,1);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (violinPool != null) {
            violinPool.release();
            violinPool = null;
        }
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