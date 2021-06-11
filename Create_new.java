package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Create_new extends AppCompatActivity {

    Button cre_new_jour_b1;
    Button cre_new_plan_b2;
    Button cre_new_entr_b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        cre_new_jour_b1 = (Button) findViewById(R.id.create_journal_b1);
        cre_new_plan_b2 = (Button) findViewById(R.id.create_planner_b2);
        cre_new_entr_b3 = (Button) findViewById(R.id.create_entry_b3);

        cre_new_entr_b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entry();
            }
        });

        cre_new_plan_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                planner();
            }
        });

        cre_new_jour_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journal();
            }
        });
    }

    private void journal()
    {
        Intent ji1 = new Intent(this, create_journal.class);
        startActivity(ji1);
    }

    private void planner()
    {
        //Intent pi1 = new Intent();
        //startActivity(pi1);
    }

    private void entry()
    {
        Intent ei1 = new Intent(this, create_entry.class);
        startActivity(ei1);
    }
}
