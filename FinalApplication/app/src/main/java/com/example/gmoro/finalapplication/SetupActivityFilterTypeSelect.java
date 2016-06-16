package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by gmoro on 2016-06-15.
 */
public class SetupActivityFilterTypeSelect extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_filter_type_select);
    }

    public void fliterRouteClick(View view) {

        Intent filterByRouteIntent = new Intent(this, SetupActivityFilterRoute.class);

        final int result = 1;

        startActivity(filterByRouteIntent);

        finish();
    }

    public void filterSchoolClick(View view) {

        Intent filterBySchoolIntent = new Intent(this, SetupActivityFilterSchool.class);

        final int result =1;

        startActivity(filterBySchoolIntent);

        finish();
    }

    public void filterBoardClick(View view) {

        Intent filterByBoardIntent = new Intent(this, SetupActivityFilterBoard.class);

        final int result = 1;

        startActivity(filterByBoardIntent);

        finish();
    }
}
