package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gmoro on 2016-06-15.
 */
public class SetupActivityFilterRoute extends Activity{

    EditText routeEntryBox;

    String searchParamater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_filter_route);

        routeEntryBox = (EditText) findViewById(R.id.route_number_entry);
    }

    public void filterRouteContinueClick(View view) {

        searchParamater = routeEntryBox.getText().toString();

        Intent searchByRouteIntent = new Intent(this, SetupActivityFilterConfirm.class);

        final int result = 1;

        searchByRouteIntent.putExtra(searchParamater,searchParamater);

        startActivity(searchByRouteIntent);

        finish();

    }
}
