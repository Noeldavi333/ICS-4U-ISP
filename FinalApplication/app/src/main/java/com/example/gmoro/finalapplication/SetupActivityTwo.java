package com.example.gmoro.finalapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by gmoro on 2016-06-15.
 */
public class SetupActivityTwo extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_two);

    }

    public void yesFilterContinueClick(View view) {

        Intent defineFilterParamatersIntent = new Intent(this, SetupActivityFilterTypeSelect.class);

        final int result = 1;

        startActivity(defineFilterParamatersIntent);

        finish();
    }

    public void noFilterContinueClick(View view) {

        Intent doNotFilterIntent = new Intent(this, SetupActivityNoFilterConfirm.class);

        final int result =1;

        startActivity(doNotFilterIntent);

        finish();
    }
}
