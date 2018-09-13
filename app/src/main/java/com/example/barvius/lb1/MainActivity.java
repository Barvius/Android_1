package com.example.barvius.lb1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnCreate();
    }

    private void BtnCreate(){
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
        button3.setOnClickListener(Btn3);
        button3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));

        buttonContainer.addView(button1);
        buttonContainer.addView(button2);
        buttonContainer.addView(button3);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        menu.add(0, 1, 0, "Первый").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Привет!", Toast.LENGTH_SHORT);
                toast.show();

                return true;
            }
        });
        menu.add(0, 2, 0, "Второй").setEnabled(false).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("MyTag", "Привет мир!");
                return true;
            }
        });
        menu.add(0, 3, 0, "Третий").setEnabled(false).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
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
                return true;
                }
        });

        return super.onCreateOptionsMenu(menu);
    }

    View.OnClickListener Btn3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            menu.findItem(3).setEnabled(true);
            EditText et = findViewById(R.id.editText);
            TextView tw = findViewById(R.id.textView);
            tw.setText(et.getText());

            menu.add(0, 4, 0, "Четвертый").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Привет!", Toast.LENGTH_SHORT);
                    toast.show();

                    return true;
                }
            });

        }
    };

    View.OnClickListener Btn2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            menu.findItem(2).setEnabled(true);
            //Intent intent = new Intent(MainActivity.this, NewActivity.class);
            //startActivity(intent);
            setContentView(R.layout.activity_new);
            findViewById(R.id.button_back).setOnClickListener(BtnBack);
        }
    };

    View.OnClickListener Btn1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else{
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }
    };


    View.OnClickListener BtnBack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setContentView(R.layout.activity_main);
            BtnCreate();
        }
    };


}
