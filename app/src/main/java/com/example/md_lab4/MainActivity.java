package com.example.md_lab4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    Button button;

    FloatingActionButton settings;
    FloatingActionButton home;
    FloatingActionButton profile;
    FloatingActionButton add;

    private boolean areAllButtonsEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        fab = findViewById(R.id.fab);
//        button = findViewById(R.id.button);
//        fab.setOnClickListener(view -> {
//            fab.setImageDrawable(getDrawable(R.drawable.close));
//        });
//
//        button.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//            startActivity(intent);
//            finish();
//        });

        setContentView(R.layout.activity_main);

        settings = findViewById(R.id.button_settings);
        home = findViewById(R.id.button_home);
        add = findViewById(R.id.button_search);
        profile = findViewById(R.id.button_profile);

        home.setVisibility(View.GONE);
        profile.setVisibility(View.GONE);
        add.setVisibility(View.GONE);

        areAllButtonsEnabled = false;


        settings.setOnClickListener(view -> {
            if (!areAllButtonsEnabled) {

                home.show();
                profile.show();
                add.show();
                settings.setImageResource(R.drawable.close);

                areAllButtonsEnabled = true;
            } else {

                home.hide();
                profile.hide();
                add.hide();
                settings.setImageResource(R.drawable.baseline_add_24);
                areAllButtonsEnabled = false;
            }
        });

        // Set click listener for the Profile FAB
        profile.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "Switched to profile", Toast.LENGTH_SHORT).show()
        );

        // Set click listener for the Home FAB
        home.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "Switched to Home", Toast.LENGTH_SHORT).show()
        );
    }
}