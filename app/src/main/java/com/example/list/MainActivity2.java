package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    int[] arr = new int[20];
    String[] str = new String[20];
    ListView lv;
    Intent gi;
    int check;
    int first;
    int multi_div;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = (ListView) findViewById(R.id.lv);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        gi = getIntent();
        check = gi.getIntExtra("Arithmetic/geometric", 1);
        first = gi.getIntExtra("first", 1);
        multi_div = gi.getIntExtra("multiplier/divider", 1);

        if (check == 0){

            for (int i = 0; i<20; i++){
                arr[i] = first + (i-1)*multi_div;
                str[i] = String.valueOf(arr [i]);

            }

        }
        else{


            for (int i = 0; i<20; i++){
                arr[i] = (int) (first * Math.pow(i-1, multi_div));
                str[i] = String.valueOf(arr [i]);

            }

        }


        ArrayAdapter<String> adp= new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,str );
        lv.setAdapter(adp);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }

    public void back(View view) {
        finish();
    }
}