package com.bekiarispanagiotis.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GuitarActivity extends AppCompatActivity implements View.OnClickListener{

    private View maxView;
    BottomNavigationView bottomNavigationView;

    private Button buttonA, buttonB, buttonD, buttonEhi, buttonElo, buttonG;
    private SoundPool guitarPool;
    private int soundA, soundB, soundD, soundEhi, soundElo, soundG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar);

        maxView = getWindow().getDecorView();
        maxView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    maxView.setSystemUiVisibility(fullScreenView());
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.guitar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.piano:
                        startActivity(new Intent(getApplicationContext(),PianoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.guitar:
                        return true;
                    case R.id.violin:
                        startActivity(new Intent(getApplicationContext(),ViolinActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_MOVIE)
                .build();
        guitarPool = new SoundPool.Builder()
                .setMaxStreams(6)
                .setAudioAttributes(audioAttributes)
                .build();

        soundA = guitarPool.load(this,R.raw.guitar_a,1);
        soundB = guitarPool.load(this,R.raw.guitar_b,1);
        soundD = guitarPool.load(this,R.raw.guitar_d,1);
        soundEhi = guitarPool.load(this,R.raw.guitar_e_hi,1);
        soundElo = guitarPool.load(this,R.raw.guitar_e_lo,1);
        soundG = guitarPool.load(this,R.raw.guitar_g,1);

        buttonA = findViewById(R.id.buttonNoteGuitarA);
        buttonB = findViewById(R.id.buttonNoteGuitarB);
        buttonD = findViewById(R.id.buttonNoteGuitarD);
        buttonEhi = findViewById(R.id.buttonNoteGuitarEhigh);
        buttonElo = findViewById(R.id.buttonNoteGuitarElow);
        buttonG = findViewById(R.id.buttonNoteGuitarG);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonEhi.setOnClickListener(this);
        buttonElo.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonNoteGuitarA:
                //play sound from button
                guitarPool.play(soundA,1,1,0,0,1);
                break;
            case R.id.buttonNoteGuitarB:
                guitarPool.play(soundB,1,1,0,0,1);
                break;
            case R.id.buttonNoteGuitarD:
                guitarPool.play(soundD,1,1,0,0,1);
                break;
            case R.id.buttonNoteGuitarEhigh:
                guitarPool.play(soundEhi,1,1,0,0,1);
                break;
            case R.id.buttonNoteGuitarElow:
                guitarPool.play(soundElo,1,1,0,0,1);
                break;
            case R.id.buttonNoteGuitarG:
                guitarPool.play(soundG,1,1,0,0,1);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (guitarPool != null) {
            guitarPool.release();
            guitarPool = null;
        }
    }
}