package com.example.gmoro.finalapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String searchParameter;

    TextView listOfRecentItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        if(searchParameter.isEmpty()){
            Intent beginSetupProcessIntent = new Intent(this, SetupActivityOne.class);

            final int result = 1;

            startActivity(beginSetupProcessIntent);
        }



    }
}
