package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        setContentView(R.layout.activity_setup_filter_route);

        //link entry point to XML object
        routeEntryBox = (EditText) findViewById(R.id.route_number_entry);
    }

    //when the user presses the continue button
    public void filterRouteContinueClick(View view) {

        //update the search parameter to users entry
        searchParameter = routeEntryBox.getText().toString();

        //create intent to send search to confirmation screen
        Intent searchByRouteIntent = new Intent(this, SetupActivityFilterConfirm.class);

        //final int as required by intent
        final int result = 1;

        //send search parameter with intent
        searchByRouteIntent.putExtra("searchParamater",searchParameter);

        //start activity
        startActivity(searchByRouteIntent);

        //close this activity
        finish();

    }
}
