package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * this window will appear to the user at the very end of the setup process, but
 * only if they choose to filter their data
 */
public class SetupActivityFilterConfirm extends Activity{

    //define holder for search parameter
    String searchParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_filter_confirm);

        //create intent to retrieve data from last screen
        Intent getSearchParameterFromLastActivityIntent = getIntent();

        //set the search parameter equal to the search parameter sent with intent
        searchParameter =
                getSearchParameterFromLastActivityIntent.getExtras().getString("searchParameter");


    }

    //when the user clicks continue
    public void filterConfirmClick(View view) {

        //create intent to change screens to main activity
        Intent sendSearchParameterToMainActivity = new Intent(this, MainActivity.class);

        //final int because the intent wants it
        final int result = 1;

        //send the search parameter with the intent
        sendSearchParameterToMainActivity.putExtra("searchParameter",searchParameter);

        //start the activity
        startActivity(sendSearchParameterToMainActivity);

        //close this activity
        finish();
    }
}
