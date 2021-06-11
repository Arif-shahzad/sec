package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class create_journal extends AppCompatActivity {

    TextView cre_jour_tv1, cre_jour_tv2, cre_jour_tv3;
    EditText cre_jour_et1, cre_jour_et2, cre_jour_et3;
    Button cre_jour_b1;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_journal);

        cre_jour_tv1 = (TextView) findViewById(R.id.create_journal_tv1);
        cre_jour_tv2 = (TextView) findViewById(R.id.create_journal_tv2);
        cre_jour_tv3 = (TextView) findViewById(R.id.create_journal_tv3);
        cre_jour_et1 = (EditText) findViewById(R.id.create_journal_et1);
        cre_jour_et2 = (EditText) findViewById(R.id.create_journal_et2);
        cre_jour_et3 = (EditText) findViewById(R.id.create_journal_et3);
        cre_jour_b1 = (Button) findViewById(R.id.create_journal_b1);

        db = new database(this);
        db.open_db();

        cre_jour_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id, name, pass;
                id = cre_jour_et1.getText().toString();
                name = cre_jour_et2.getText().toString();
                pass = cre_jour_et3.getText().toString();

                journal_model journal = new journal_model();
                journal.setId(id);
                journal.setName(name);
                journal.setPassword(Integer.parseInt(pass));

                db.insert_journal(journal);

                Toast errorToast = Toast.makeText(create_journal.this, "Created successfullly", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });
    }
}