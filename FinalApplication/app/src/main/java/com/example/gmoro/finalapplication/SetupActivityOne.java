package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by gmoro on 2016-06-15.
 */
public class SetupActivityOne extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_one);
    }

    public void setupContinueClick(View view) {

        Intent continueToScreen2Intent = new Intent(this, SetupActivityTwo.class);

        final int result = 1;

        startActivity(continueToScreen2Intent);

        finish();
    }
}
