package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;

    public String searchParameter = "", dateTimeOut, dateTimeString;
    TextView listOfRecentItems, dateViewOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        activity = this;
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //load saved search parameter
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        searchParameter = sp.getString("searchParameter", searchParameter);

        listOfRecentItems = (TextView) findViewById(R.id.notification_view);


        //if there has not been a search parameter defined
        if (searchParameter.length() == 0) {
            //define the intent to load the setup process
            Intent beginSetupProcessIntent = new Intent(this, SetupActivityOne.class);

            //final result for whatever reason the intent needs one
            final int result = 1;

            //start this setup process
            startActivity(beginSetupProcessIntent);

            //this intent will not close off the main activity process, instead it will continue
            //running in the background. It does not need to close as the user will back in a couple
            //of minutes.
        } else {
            //run the update rss feed

            //clear box
            listOfRecentItems.setText("");

            refresh();
    }
    }


    public void refresh() {
        //creating a new instance of the class that does the parsing
        HandleXML obj = new HandleXML();
        //calling the required function
        obj.fetchXML(searchParameter);

        //show the resulting output
        while (obj.parseComplete = false) {

            //literally nothing
        }

    }
}