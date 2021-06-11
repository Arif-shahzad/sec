package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class open_journal extends AppCompatActivity {

    Button lis, ope;
    TextView t1, t2;
    EditText e1, e2;
    database db;
    List<journal_model> journals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_journal);

        lis = (Button) findViewById(R.id.open_journal_b1);
        ope = (Button) findViewById(R.id.open_journal_b2);
        t1 = (TextView) findViewById(R.id.open_journal_tv1);
        t2 = (TextView) findViewById(R.id.open_journal_tv2);
        e1 = (EditText) findViewById(R.id.open_journal_et1);
        e2 = (EditText) findViewById(R.id.open_journal_et2);

        db = new database(this);
        db.open_db();

        journals = db.get_journals();

        lis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_list_display();
            }
        });

        ope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id, password;
                int z;
                id = e1.getText().toString();
                password = e2.getText().toString();
                for(z = 0 ; z<journals.size() ; z++)
                    if(journals.get(z).getId().equalsIgnoreCase(id))
                        break;
                if(z<journals.size())
                {
                    if(Integer.toString(journals.get(z).getPassword()).equalsIgnoreCase(password))
                        call_open_entry(z);
                    else
                    {
                        Toast errorToast = Toast.makeText(open_journal.this, "Error, incorrect id or password!", Toast.LENGTH_SHORT);
                        errorToast.show();
                    }
                }
                else
                {
                    Toast errorToast = Toast.makeText(open_journal.this, "Error, incorrect id or password!", Toast.LENGTH_SHORT);
                    errorToast.show();
                }
            }
        });
    }

    public void call_list_display()
    {
        Intent i = new Intent(this, journal_list_diaplay.class);
        startActivity(i);
    }

    public void call_open_entry(int z)
    {
        Intent i = new Intent(this, open_entry.class);
        i.putExtra("msg1", journals.get(z).getId());
        startActivity(i);
    }
}
