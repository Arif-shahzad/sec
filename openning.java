package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class openning extends AppCompatActivity {

    Button open_jour_b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openning);

        open_jour_b1 = (Button) findViewById(R.id.open_journal_b1);

        open_jour_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journal();
            }
        });
    }

    private void journal()
    {
        Intent j1 = new Intent(this, open_journal.class);
        startActivity(j1);
    }
}
