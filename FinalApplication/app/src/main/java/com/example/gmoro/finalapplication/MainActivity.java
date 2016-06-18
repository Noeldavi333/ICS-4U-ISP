package com.example.gmoro.finalapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String searchParameter;

    TextView listOfRecentItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

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

        if(searchParameter.isEmpty()){
            Intent beginSetupProcessIntent = new Intent(this, SetupActivityOne.class);

            final int result = 1;

            startActivity(beginSetupProcessIntent);
        }



    }
}
