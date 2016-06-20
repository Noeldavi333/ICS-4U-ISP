package com.example.gmoro.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    String searchParameter = "",dateTimeOut, dateTimeString;

    TextView listOfRecentItems,dateViewOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //load saved search parameter
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        searchParameter = sp.getString("searchParameter", searchParameter);


        //if there has not been a search parameter defined
        if(searchParameter.length()==0){
            //define the intent to load the setup process
            Intent beginSetupProcessIntent = new Intent(this, SetupActivityOne.class);

            //final result for whatever reason the intent needs one
            final int result = 1;

            //start this setup process
            startActivity(beginSetupProcessIntent);

            //this intent will not close off the main activity process, instead it will continue
            //running in the background. It does not need to close as the user will back in a couple
            //of minutes.
        }
        else {
            //reading in the rss feed

            int event;
            String text=null;


            try {
                // connecting to the rss feed
                URL url = new URL("https://portal.nsts.ca/rss/feed-en-CA.xml"); //tell the program where the RSS is locatued
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                // Starts the query
                conn.connect();

                //getting a stream the parser can use
                InputStream stream = conn.getInputStream();

                //creating the parser
                XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
                XmlPullParser parser = xppf.newPullParser();

                parser.setInput(stream, null);

                event = parser.getEventType();

                //parse through the entire document until the end is reached
                while (event != XmlPullParser.END_DOCUMENT) {
                    String name = parser.getName();

                    switch (event){
                        case XmlPullParser.START_TAG:
                            //at the opening tag
                            break;

                        case XmlPullParser.TEXT:
                            //gets the text from inside the tag
                            text = parser.getText();
                            break;

                        case XmlPullParser.END_TAG:
                            // after reading the contents of the tag
                            if(name.equals("title")){
                                // read in whatever the text contains. I'm not sure exactly which tags we will have
                                // but we should read the contents into ArrayLists (by tag?) to be searched from later
                                // titleList.Add(text)
                            }

                            else if(name.equals("link")){
                                //linkList.add(text)
                            }

                            else if(name.equals("description")){
                                //etc
                            }

                            break;
                    }
                    //move to the next part of the file
                    event = parser.next();
                }

                //parsingComplete = false;
            }

            catch (Exception e) {
                // java likes these try/catch setups :)
            }
        }

    }

}
