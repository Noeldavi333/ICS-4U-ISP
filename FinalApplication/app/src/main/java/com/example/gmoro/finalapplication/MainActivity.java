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
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String searchParameter = "",dateTimeOut, dateTimeString;

    TextView listOfRecentItems,dateViewOut;

    ArrayList titleText, dateText, descriptionText;

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
                URL url = new URL("https://portal.nsts.ca/rss/feed-en-CA.xml"); //tell the program where the RSS is located
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

                String title = "", description = "", date = "";
                Boolean relevant = false;

                //parse through the entire document until the end is reached
                while (event != XmlPullParser.END_DOCUMENT) {

                    //get the tag's name
                    String name = parser.getName();

                    switch (event) {
                        case XmlPullParser.START_TAG:
                            //at the opening tag
                            break;

                        case XmlPullParser.TEXT:


                            if (name.equals("pubDate")) {
                                //this tag has the date
                                date = parser.getText();
                            }


                            break;
                        case XmlPullParser.COMMENT:
                            if (name.equals("title")) {
                                //this tag contains the route number

                                //reading in the value
                                title = parser.getText();
                                //if that doesn't work, try:
                                //title = parser.getName or .getNameSpace

                                //If the specified route number is in here, we'll want to keep this item
                                if (title.contains(searchParameter)) {
                                    relevant = true;
                                }
                            } else if (name.equals("description")) {
                                //this tag has the school
                                description = parser.getText();

                                if (description.contains(searchParameter)) {
                                    relevant = true;
                                }
                            }
                            break;

                        case XmlPullParser.END_TAG:
                            // after reading all the contents of the "item" parent element
                            if ((name.equals("item")) && (title.contains("Route"))) { //checking to see that it's not a "no closures" or "no general notifications
                                if (relevant == true) {
                                    //printing out relevant info... we'll have
                                    //to cut up the strings a bit
                                    //because they look yucky as-is

                                    //Separating the route data and the bus status
                                    String route = title.substring(title.indexOf("Route"), title.indexOf("Status"));
                                    String status = title.substring(title.indexOf("Status"), title.indexOf("]"));

                                    //Separating the affected school out of the description
                                    String school = description.substring(description.indexOf("Schools"), description.indexOf("</p>]]"));

                                    // print out route, status, school, date to the text field
                                    // **I Don't know what your textfield is called**


                                    //and reset the boolean
                                    relevant = false;
                                }
                            }


                            break;
                    }
                    //move to the next part of the file
                    event = parser.next();
                }


            }

            catch (Exception e) {
                // java likes these try/catch setups :)
            }
        }

    }

}
