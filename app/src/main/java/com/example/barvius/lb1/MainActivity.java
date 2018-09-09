package com.example.barvius.lb1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.ButtonContainer);

        Button button1 = new Button(this);
        button1.setText("Первый");
        button1.setOnClickListener(Btn1);
        button1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 3));

        Button button2 = new Button(this);
        button2.setText("Второй");
        button2.setOnClickListener(Btn2);
        button2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));

        Button button3 = new Button(this);
        button3.setText("Третий");
        //button3.onOptionsItemSelected();
        button3.setOnClickListener(Btn3);
        button3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));

        buttonContainer.addView(button1);
        buttonContainer.addView(button2);
        buttonContainer.addView(button3);
    }


    View.OnClickListener Btn3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "Кот сыт!", Toast.LENGTH_LONG);
//            toast.show();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle("Внимание!")
                    .setMessage("Спасибо за внимание!")
                    .setCancelable(false)
                    .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();

            EditText et = findViewById(R.id.editText);
            TextView tw = findViewById(R.id.textView);
            tw.setText(et.getText());
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            // Get the layout inflater
//            LayoutInflater inflater = (LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            // Inflate and set the layout for the dialog
//            // Pass null as the parent view because its going in the dialog layout
//            builder.setView(inflater.inflate(R.layout.dialog, null))
//                    // Add action buttons
//                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int id) {
//                            // sign in the user ...
//                        }
//                    })
//                    .setNegativeButton("not ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            dialog.cancel();
//                        }
//                    });
//            builder.create();
        }
    };

    View.OnClickListener Btn2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener Btn1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Кот сыт!", Toast.LENGTH_SHORT);
            toast.show();


            if(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    };


}
