package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * this window will appear to the user at the very end of the setup process, but
 * only if they choose to filter their data
 */
public class SetupActivityFilterConfirm extends Activity{

    //define holder for search parameter
    String searchParameter;

    TextView searchPreviewWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setup_filter_confirm);

        //create intent to retrieve data from last screen
        Intent getSearchParameterFromLastActivityIntent = getIntent();

        //set the search parameter equal to the search parameter sent with intent
        searchParameter =
                getSearchParameterFromLastActivityIntent.getExtras().getString("searchParameter");


        //define and display the search parameter in the window

        searchPreviewWindow = (TextView)findViewById(R.id.search_parameter_preview);
        searchPreviewWindow.setText(searchParameter);
    }

    //when the user clicks continue
    public void filterConfirmClick(View view) throws IOException, FileNotFoundException{

        //create intent to change screens to main activity
        Intent sendSearchParameterToMainActivity = new Intent(this, MainActivity.class);

        //final int because the intent wants it
        final int result = 1;

        //send the search parameter with the intent
        sendSearchParameterToMainActivity.putExtra("searchParameter",searchParameter);

        //start the activity
        startActivity(sendSearchParameterToMainActivity);

        //save the search parameter for future runs

        //get the file
        File file = new File("SaveFile.txt");

        //Overwrites the file (True would append to the file).
        FileWriter fw = new FileWriter(file, false);

        //PrintWriter allows writing to a file one line at a time
        PrintWriter writer = new PrintWriter(fw);

        //Now we can write all the variables we want to store to the file.
        writer.println(searchParameter);

        //Closes the file.
        writer.close();
        fw.close();


        //close this activity
        finish();
    }

    //when the button to go back is pressed
    public void goBackButtonPress(View view) {

        //create intent go back to last screen
        Intent goBackToFilterTypeSelect = new Intent(this,SetupActivityFilterTypeSelect.class);

        //result because intents want it
        final int result = 1;

        //start activity
        startActivity(goBackToFilterTypeSelect);

        //close this window
        finish();
    }

}
