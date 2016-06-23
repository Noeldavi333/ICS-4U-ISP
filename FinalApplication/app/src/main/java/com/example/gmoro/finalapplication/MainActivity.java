package com.example.gmoro.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String searchParameter = "", dateTimeOut, dateTimeString;
    TextView listOfRecentItems, dateViewOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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




    }
    }


    public void refresh() {
        //creating a new instance of the class that does the parsing
        HandleXML obj = new HandleXML();
        //calling the required function
        obj.fetchXML(searchParameter);

        while(obj.parsingComplete){/* wait for parsing to finish*/}
        //show the resulting output
        listOfRecentItems.setText(obj.getOutput());
    }
}