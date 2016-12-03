package com.wordpress.michaelkyazze.codeperspective101;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class Splash extends Activity implements Runnable{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hHandler = new Handler();
        hHandler.postDelayed(this, 3500);


    }

    @Override
    public void run() {
        startActivity(new Intent(this, NDMain.class));
        finish();

    }
}
