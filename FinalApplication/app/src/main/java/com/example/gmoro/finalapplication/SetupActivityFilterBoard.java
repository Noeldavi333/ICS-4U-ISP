package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gmoro on 2016-06-15.
 */
public class SetupActivityFilterBoard extends Activity{

    EditText boardEntryBox;

    String searchParamater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_filter_board);

        boardEntryBox = (EditText)findViewById(R.id.board_entry_box);
    }

    public void filterBoardContinueClick(View view) {

        searchParamater = boardEntryBox.getText().toString();

        Intent searchByBoardIntent = new Intent(this, SetupActivityFilterConfirm.class);

        final int result = 1;

        searchByBoardIntent.putExtra(searchParamater,searchParamater);

        startActivity(searchByBoardIntent);

        finish();
    }
}
