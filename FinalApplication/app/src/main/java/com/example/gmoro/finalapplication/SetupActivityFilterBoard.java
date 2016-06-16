package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

        setContentView(R.layout.activity_setup_filter_board);

        //find entry box in XML
        boardEntryBox = (EditText)findViewById(R.id.board_entry_box);
    }

    //when the user preses continue
    public void filterBoardContinueClick(View view) {

        //set the search parameter to their input
        searchParameter = boardEntryBox.getText().toString();

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
