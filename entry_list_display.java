package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class entry_list_display extends AppCompatActivity {

    TextView tv;
    database db;
    List<entry_model> li = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_list_display);

        tv = (TextView) findViewById(R.id.entry_list_display_tv1);

        Intent i = getIntent();

        String jou_id = i.getStringExtra("msg1");

        db = new database(this);
        db.open_db();

        li = db.get_entries();

        String dis = "";

        for(int z = 0 ; z<li.size() ; z++)
        {
            if(li.get(z).getJour_id().equalsIgnoreCase(jou_id))
                dis += "ID:  "+li.get(z).getId()+"\n"+"TOPIC:  "+li.get(z).getTopic()+"\n\n";
        }

        tv.setText(dis);
    }
}
