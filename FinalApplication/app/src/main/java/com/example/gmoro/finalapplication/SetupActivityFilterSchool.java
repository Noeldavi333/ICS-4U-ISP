package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gmoro on 2016-06-15.
 */
public class SetupActivityFilterSchool extends Activity {

    EditText schoolEntryBox;

    String searchParamater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setup_filter_school);

        schoolEntryBox = (EditText)findViewById(R.id.school_entry_box);
    }

    public void filterSchoolContinueClick(View view) {

        searchParamater = schoolEntryBox.getText().toString();

        Intent searchBySchoolIntent = new Intent(this, SetupActivityFilterConfirm.class);

        searchBySchoolIntent.putExtra(searchParamater,searchParamater);

        final int result = 1;

        startActivity(searchBySchoolIntent);

        finish();
    }
}
