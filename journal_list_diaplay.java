package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class journal_list_diaplay extends AppCompatActivity {

    TextView tv;
    database db;
    List<journal_model> li = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_list_diaplay);

        tv = (TextView) findViewById(R.id.journal_list_display_tv1);

        db = new database(this);
        db.open_db();

        li = db.get_journals();

        String dis = "";

        for(int z = 0 ; z<li.size() ; z++)
            dis += "ID:  "+li.get(z).getId()+"\n"+"NAME:  "+li.get(z).getName()+"\n\n";

        tv.setText(dis);
    }
}
