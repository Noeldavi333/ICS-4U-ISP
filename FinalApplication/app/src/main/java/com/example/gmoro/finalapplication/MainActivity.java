package com.example.gmoro.finalapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String searchParameter,dateTimeOut, dateTimeString;

    TextView listOfRecentItems,dateViewOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //add the date and time to the application header
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d  HH:mm");

        dateFormat.getCalendar();

        //convert date to usable format

        //load the saved search parameter

        //Finds the file with this name. Since there is no file path, it looks in the project folder
        File file = new File("SaveFile.txt");

        //trying to prevent a crash if the save file is somehow deleted
        try{
        Scanner scanner = new Scanner(file);

        //avoiding a scanner error if file is blank
        if(scanner.hasNextLine()) {
            //read the first line of the file into the search parameter
            searchParameter = scanner.nextLine();
        }

        //Closing the scanner
        scanner.close();

        }catch(FileNotFoundException f){
            /*really this should never happen,
              but if it does the search parameter will be empty
              and the user will be directed to the setup*/
        }

        //if there has not been a search parameter defined
        if(searchParameter.isEmpty()){
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



    }
}
