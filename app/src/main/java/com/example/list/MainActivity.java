package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    Switch sw;
    Button btn;
    String str;
    String str2;
    Intent si;
    int num1;
    int num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        sw = (Switch) findViewById(R.id.sw);
        btn = (Button) findViewById(R.id.btn);

    }

    public void move(View view) {

        str = et1.getText().toString();
        str2 = et2.getText().toString();

        if (str.isEmpty() || str2.isEmpty()){
            Toast.makeText(this, "please fill all lines", Toast.LENGTH_SHORT).show();
        }

        else{
            si = new Intent(this, MainActivity2.class);


            if (sw.isChecked()){
                si.putExtra("Arithmetic/geometric", 0);

            }
            else{
                si.putExtra("Arithmetic/geometric", 1);

            }


            num1 = Integer.parseInt(str);
            num2 = Integer.parseInt(str2);



            si.putExtra("first", num1);
            si.putExtra("multiplier/divider", num2);


            startActivity(si);

        }
    }

}