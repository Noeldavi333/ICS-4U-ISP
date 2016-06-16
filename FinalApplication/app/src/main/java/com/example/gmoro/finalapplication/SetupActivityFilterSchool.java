package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

/**
 * this window will appear if the user elects to filter their data by school name
 */
public class SetupActivityFilterSchool extends Activity {

    //define text entry point
    EditText schoolEntryBox;

    //define search string
    String searchParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setup_filter_school);

        //link text entry point to XML object
        schoolEntryBox = (EditText)findViewById(R.id.school_entry_box);
    }

    //when the user presses continue
    public void filterSchoolContinueClick(View view) {

        //update search parameter to their input
        searchParameter = schoolEntryBox.getText().toString();

        if(searchParameter.isEmpty()){
            //toast thing
        }
        else{
            //create intent to move to main activity
            Intent searchBySchoolIntent = new Intent(this, SetupActivityFilterConfirm.class);

            //send search parameter with intent
            searchBySchoolIntent.putExtra("searchParamater",searchParameter);

            //final int because Intent wants it
            final int result = 1;

            //start the activity
            startActivity(searchBySchoolIntent);

            //close this activity
            finish();
        }
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
