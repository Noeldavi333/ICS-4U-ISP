package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * This is the first screen the user will encounter in the application
 * It will introduce them to the app and allow them to continue
 */
public class SetupActivityOne extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_one);
    }

    //when the continue button is pressed (defined in xml)
    public void setupContinueClick(View view) {

        //create the intent to jump to the next screen (setup 2)
        Intent continueToScreen2Intent = new Intent(this, SetupActivityTwo.class);

        //define the result int as required by Intents
        final int result = 1;

        //Start the Intent and not ask for result
        startActivity(continueToScreen2Intent);

        //close this activity
        finish();
    }
}
