package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class entry_display extends AppCompatActivity {

    TextView en_tv1, en_tv2, en_tv3, en_tv4, en_tv5, en_tv6, en_tv7, en_tv8, en_tv9, en_tv10, en_tv11, en_tv12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_display);

        en_tv1 = (TextView) findViewById(R.id.entry_diaplay_tv1);
        en_tv2 = (TextView) findViewById(R.id.entry_display_tv2);
        en_tv3 = (TextView) findViewById(R.id.entry_display_tv3);
        en_tv4 = (TextView) findViewById(R.id.entry_display_tv4);
        en_tv5 = (TextView) findViewById(R.id.entry_display_tv5);
        en_tv6 = (TextView) findViewById(R.id.entry_display_tv6);
        en_tv7 = (TextView) findViewById(R.id.entry_display_tv7);
        en_tv8 = (TextView) findViewById(R.id.entry_display_tv8);
        en_tv9 = (TextView) findViewById(R.id.entry_display_tv9);
        en_tv10 = (TextView) findViewById(R.id.entry_display_tv10);
        en_tv11 = (TextView) findViewById(R.id.entry_display_tv11);
        en_tv12 = (TextView) findViewById(R.id.entry_display_tv12);

        Intent i = getIntent();

        String id = i.getStringExtra("msg1");
        String jid = i.getStringExtra("msg2");
        String topic = i.getStringExtra("msg3");
        String text = i.getStringExtra("msg4");
        String path = i.getStringExtra("msg5");
        String date = i.getStringExtra("msg6");

        en_tv2.setText(id);
        en_tv4.setText(jid);
        en_tv6.setText(topic);
        en_tv8.setText(text);
        en_tv10.setText(path);
        en_tv12.setText(date);
    }
}
