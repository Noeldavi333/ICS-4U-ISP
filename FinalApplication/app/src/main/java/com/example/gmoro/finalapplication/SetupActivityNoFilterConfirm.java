package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * this window will appear at the end of setup, but only if the user does not filter their data
 */
public class SetupActivityNoFilterConfirm extends Activity {

    //define the search parameter string
    String searchParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setup_no_filter_confirm);
    }

    //when the user clicks the continue button
    public void noFilterConfirmClick(View view) throws IOException{

        //set the search parameter to space (something all items will include)
        searchParameter = " ";

        //create intent to send search parameter to main window
        Intent sendNullSearchParameter = new Intent(this, MainActivity.class);

        //define final int as required by intents
        final int result = 1;

        //send the search parameter with launch request
        sendNullSearchParameter.putExtra("searchParameter", searchParameter);

        //start the activity
        startActivity(sendNullSearchParameter);

        //save the search parameter for future runs
        SharedPreferences sp =
                getSharedPreferences("MyPrefs",
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("searchParameter", searchParameter);
        editor.commit();

        //close this activity
        finish();
    }

    //when the button to go back is pressed
    public void goBackButtonPress(View view) {

        //create intent go back to last screen
        Intent goBackToSetup2 = new Intent(this,SetupActivityTwo.class);

        //result because intents want it
        final int result = 1;

        //start activity
        startActivity(goBackToSetup2);

        //close this window
        finish();
    }
}
