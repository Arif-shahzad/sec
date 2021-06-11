package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button c_b1;
    Button o_b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c_b1 = (Button) findViewById(R.id.create_b1);
        o_b2 = (Button) findViewById(R.id.open_b2);

        c_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cre();
            }
        });

        o_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ope();
            }
        });
    }

    private void cre()
    {
        Intent i1 = new Intent(this, Create_new.class);
        startActivity(i1);
    }

    private void ope()
    {
        Intent i2 = new Intent(this, openning.class);
        startActivity(i2);
    }
}
