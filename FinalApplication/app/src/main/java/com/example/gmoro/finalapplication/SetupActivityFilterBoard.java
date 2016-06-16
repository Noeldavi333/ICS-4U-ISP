package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This window will appear if the user elects to filter their data by school board
 */
public class SetupActivityFilterBoard extends Activity{

    //define entry box
    EditText boardEntryBox;

    //define search parameter
    String searchParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setup_filter_board);

        //find entry box in XML
        boardEntryBox = (EditText)findViewById(R.id.board_entry_box);
    }

    //when the user preses continue
    public void filterBoardContinueClick(View view) {

        //set the search parameter to their input
        searchParameter = boardEntryBox.getText().toString();

        if (searchParameter.isEmpty()){
            //toast thing
            Toast.makeText(SetupActivityFilterBoard.this,
                    "Field Cannot Be Empty!", Toast.LENGTH_LONG).show();
        }
        else {
            //create intent to switch to confirmation window
            Intent searchByBoardIntent = new Intent(this, SetupActivityFilterConfirm.class);

            //final result because of the intent
            final int result = 1;

            //send search parameter with intent
            searchByBoardIntent.putExtra("searchParameter",searchParameter);

            //start intent
            startActivity(searchByBoardIntent);

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
