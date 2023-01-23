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
import com.google.android.material.navigation.NavigationBarView;

public class PianoActivity extends AppCompatActivity implements View.OnClickListener{

    private View maxView;
    BottomNavigationView bottomNavigationView;

    private Button buttonA, buttonAS, buttonB, buttonC, buttonCS, buttonCH, buttonD, buttonDS, buttonE, buttonF, buttonFS, buttonG, buttonGS;
    private SoundPool pianoPool;
    private int soundA, soundAS, soundB, soundC, soundCS, soundCH, soundD, soundDS, soundE, soundF, soundFS, soundG, soundGS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        maxView = getWindow().getDecorView();
        maxView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    maxView.setSystemUiVisibility(fullScreenView());
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.piano);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.piano:
                        return true;
                    case R.id.guitar:
                        startActivity(new Intent(getApplicationContext(),GuitarActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.violin:
                        startActivity(new Intent(getApplicationContext(),ViolinActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //load sounds to cache
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        pianoPool = new SoundPool.Builder()
                .setMaxStreams(13)
                .setAudioAttributes(audioAttributes)
                .build();

        soundA = pianoPool.load(this,R.raw.piano_a,1);
        soundAS = pianoPool.load(this,R.raw.piano_as,1);
        soundB = pianoPool.load(this,R.raw.piano_b,1);
        soundC = pianoPool.load(this,R.raw.piano_c,1);
        soundCS = pianoPool.load(this,R.raw.piano_cs,1);
        soundCH = pianoPool.load(this,R.raw.piano_c_hi,1);
        soundD = pianoPool.load(this,R.raw.piano_d,1);
        soundDS = pianoPool.load(this,R.raw.piano_ds,1);
        soundE = pianoPool.load(this,R.raw.piano_e,1);
        soundF = pianoPool.load(this,R.raw.piano_f,1);
        soundFS = pianoPool.load(this,R.raw.piano_fs,1);
        soundG = pianoPool.load(this,R.raw.piano_g,1);
        soundGS = pianoPool.load(this,R.raw.piano_gs,1);

        buttonA = findViewById(R.id.buttonNotePianoA);
        buttonAS = findViewById(R.id.buttonNotePianoAsharp);
        buttonB = findViewById(R.id.buttonNotePianoB);
        buttonC = findViewById(R.id.buttonNotePianoC);
        buttonCS = findViewById(R.id.buttonNotePianoCsharp);
        buttonCH = findViewById(R.id.buttonNotePianoChi);
        buttonD = findViewById(R.id.buttonNotePianoD);
        buttonDS = findViewById(R.id.buttonNotePianoDsharp);
        buttonE = findViewById(R.id.buttonNotePianoE);
        buttonF = findViewById(R.id.buttonNotePianoF);
        buttonFS = findViewById(R.id.buttonNotePianoFsharp);
        buttonG = findViewById(R.id.buttonNotePianoG);
        buttonGS = findViewById(R.id.buttonNotePianoGsharp);

        buttonA.setOnClickListener(this);
        buttonAS.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonCS.setOnClickListener(this);
        buttonCH.setOnClickListener(this);
        buttonD.setOnClickListener(this);
        buttonDS.setOnClickListener(this);
        buttonE.setOnClickListener(this);
        buttonF.setOnClickListener(this);
        buttonFS.setOnClickListener(this);
        buttonG.setOnClickListener(this);
        buttonGS.setOnClickListener(this);

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
            case R.id.buttonNotePianoA:
                //play sound from button
                pianoPool.play(soundA,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoAsharp:
                pianoPool.play(soundAS,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoB:
                pianoPool.play(soundB,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoC:
                pianoPool.play(soundC,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoCsharp:
                pianoPool.play(soundCS,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoChi:
                pianoPool.play(soundCH,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoD:
                pianoPool.play(soundD,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoDsharp:
                pianoPool.play(soundDS,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoE:
                pianoPool.play(soundE,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoF:
                pianoPool.play(soundF,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoFsharp:
                pianoPool.play(soundFS,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoG:
                pianoPool.play(soundG,1,1,0,0,1);
                break;
            case R.id.buttonNotePianoGsharp:
                pianoPool.play(soundGS,1,1,0,0,1);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (pianoPool != null) {
            pianoPool.release();
            pianoPool = null;
        }
    }
}