package com.linsr.languagedemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.english).setOnClickListener(this);
        findViewById(R.id.zh_cn).setOnClickListener(this);
        findViewById(R.id.zh_tw).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Resources resources = getResources();
        final Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        switch (v.getId()) {
            case R.id.english:
                configuration.locale = Locale.ENGLISH;
                break;
            case R.id.zh_cn:
                configuration.locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case R.id.zh_tw:
                configuration.locale = Locale.TRADITIONAL_CHINESE;
                break;
        }
        getResources().updateConfiguration(configuration, displayMetrics);

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

}
