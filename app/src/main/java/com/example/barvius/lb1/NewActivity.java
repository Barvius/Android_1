package com.example.barvius.lb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }


        public void Back(View v) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


}
