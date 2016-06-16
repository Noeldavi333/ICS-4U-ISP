package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * this window will prompt the user if they elect to filter their data
 */
public class SetupActivityFilterTypeSelect extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_filter_type_select);
    }

    //if they select to filter by route
    public void fliterRouteClick(View view) {

        //create intent to switch to route window
        Intent filterByRouteIntent = new Intent(this, SetupActivityFilterRoute.class);

        //final int
        final int result = 1;

        //start activity
        startActivity(filterByRouteIntent);

        //close thsi window
        finish();
    }

    //if the user selects to filter by school
    public void filterSchoolClick(View view) {

        //create intent to switch to school screen
        Intent filterBySchoolIntent = new Intent(this, SetupActivityFilterSchool.class);

        //result
        final int result =1;

        //send intent
        startActivity(filterBySchoolIntent);

        //close this window
        finish();
    }

    //if the user selects to filter by school board
    public void filterBoardClick(View view) {

        //create intent to switch to board winow
        Intent filterByBoardIntent = new Intent(this, SetupActivityFilterBoard.class);

        //result
        final int result = 1;

        //send intent
        startActivity(filterByBoardIntent);

        //close this window
        finish();
    }
}
