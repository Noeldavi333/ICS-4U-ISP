package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

/**
 * this window will appear if the user elects to filter their data by bus route
 */
public class SetupActivityFilterRoute extends Activity{

    //define text entry point
    EditText routeEntryBox;

    //define search string
    String searchParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setup_filter_route);

        //link entry point to XML object
        routeEntryBox = (EditText) findViewById(R.id.route_number_entry);
    }

    //when the user presses the continue button
    public void filterRouteContinueClick(View view) {

        //update the search parameter to users entry
        searchParameter = routeEntryBox.getText().toString();

        //if the text box is empty
        if (searchParameter.isEmpty()){
            //toast thing
            Toast.makeText(SetupActivityFilterRoute.this,
                    "Field Cannot Be Empty!", Toast.LENGTH_LONG).show();
        }
        else{

            //create intent to send search to confirmation screen
            Intent searchByRouteIntent = new Intent(this, SetupActivityFilterConfirm.class);

            //final int as required by intent
            final int result = 1;

            //send search parameter with intent
            searchByRouteIntent.putExtra("searchParameter",searchParameter);

            //start activity
            startActivity(searchByRouteIntent);

            //close this activity
            finish();
        }

    }

    //when the button to go back is pressed
    public void goBackButtonPress(View view) {

        //create intent go back to last screen
        Intent goBackToFilterTypeSelect = new Intent(this,SetupActivityFilterTypeSelect.class);

        //result because intents want it
        final int result = 1;

        //start activity
        startActivity(goBackToFilterTypeSelect);

        //close this window
        finish();
    }
}
