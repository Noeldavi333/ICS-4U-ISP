package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MainActivity extends AppCompatActivity {

    public static Activity activity;

    public String searchParameter = "", dateTimeOut, dateTimeString;
    static TextView alsoListOfRecentObjects, dateViewOut;

    static boolean relevant;

    static String title, description, date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        activity = this;
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        alsoListOfRecentObjects = (TextView) MainActivity.activity.findViewById(R.id.notification_view);


        //load saved search parameter
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        searchParameter = sp.getString("searchParameter", searchParameter);


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

           // HandleXML.fetchXML(searchParameter);
        }
    }

    public static void onProgressUpdate(String searchParameter, Element currentElement) {

        alsoListOfRecentObjects.setText("");


}
}