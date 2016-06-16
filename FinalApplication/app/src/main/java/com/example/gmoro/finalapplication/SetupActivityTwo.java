package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * This is the second window the user will see in the set up process
 */
public class SetupActivityTwo extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_two);

    }

    //when the user chooses to filter the data
    public void yesFilterContinueClick(View view) {

        //create intent to jump filter type screen
        Intent defineFilterParamatersIntent = new Intent(this, SetupActivityFilterTypeSelect.class);

        //create result as required by intents
        final int result = 1;

        //start the Intend without requesting results
        startActivity(defineFilterParamatersIntent);

        //close this screen from the background
        finish();
    }

    //if the user elects to not filter their data
    public void noFilterContinueClick(View view) {

        //create intent to jump to the confirmation page
        Intent doNotFilterIntent = new Intent(this, SetupActivityNoFilterConfirm.class);

        //result int as required by intents
        final int result =1;

        //start activity - do not request result
        startActivity(doNotFilterIntent);

        //close this activity from the background
        finish();
    }
}
