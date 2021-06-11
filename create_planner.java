package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class create_planner extends AppCompatActivity {

    Button c_p_b1;
    Button c_p_b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_planner);

        c_p_b1 = (Button) findViewById(R.id.create_planner_b1);
        c_p_b2 = (Button) findViewById(R.id.create_planner_b2);

        c_p_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                to_do_list();
            }
        });

        c_p_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reminder();
            }
        });
    }

    private void to_do_list()
    {
        //Intent i = new Intent(this, );
        //startActivity(i);
    }

    private void reminder()
    {
        //Intent i = new Intent(this, );
        //startActivity(i);
    }
}
