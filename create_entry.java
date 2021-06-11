package com.example.projectsec;

import androidx.annotation.Nullable;
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

public class create_entry extends AppCompatActivity {

    TextView cre_ent_tv1, cre_ent_tv2, cre_ent_tv3, cre_ent_tv4, cre_ent_tv5, cre_ent_tv6, cre_ent_tv7;
    EditText cre_ent_et1, cre_ent_et2, cre_ent_et3, cre_ent_et4, cre_ent_et5;
    Button cre_ent_b1, cre_ent_b2;
    String p;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_entry);

        cre_ent_tv1 = (TextView) findViewById(R.id.create_entry_tv1);
        cre_ent_tv2 = (TextView) findViewById(R.id.create_entry_tv2);
        cre_ent_tv3 = (TextView) findViewById(R.id.create_entry_tv3);
        cre_ent_tv4 = (TextView) findViewById(R.id.create_entry_tv4);
        cre_ent_tv5 = (TextView) findViewById(R.id.create_entry_tv5);
        cre_ent_tv6 = (TextView) findViewById(R.id.create_entry_tv6);
        cre_ent_tv7 = (TextView) findViewById(R.id.create_entry_tv7);

        cre_ent_et1 = (EditText) findViewById(R.id.create_entry_et1);
        cre_ent_et2 = (EditText) findViewById(R.id.create_entry_et2);
        cre_ent_et3 = (EditText) findViewById(R.id.create_entry_et3);
        cre_ent_et4 = (EditText) findViewById(R.id.create_entry_et4);
        cre_ent_et5 = (EditText) findViewById(R.id.create_entry_et5);

        cre_ent_b1 = (Button) findViewById(R.id.create_entry_b1);
        cre_ent_b2 = (Button) findViewById(R.id.create_entry_b2);

        db = new database(this);
        db.open_db();

        cre_ent_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("*/*");
                startActivityForResult(i, 10);
            }
        });

        cre_ent_b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id, Jou_id,topic, text, path, date;
                id = cre_ent_et1.getText().toString();
                Jou_id = cre_ent_et5.getText().toString();
                topic = cre_ent_et2.getText().toString();
                text = cre_ent_et3.getText().toString();
                path = p;
                date = cre_ent_et4.getText().toString();

                List<journal_model> lis = new ArrayList<>();
                lis = db.get_journals();
                int z;
                for(z = 0 ; z<lis.size() ; z++)
                    if (lis.get(z).getId().equalsIgnoreCase(Jou_id))
                        break;
                if(z<lis.size())
                {
                    entry_model entry = new entry_model();
                    entry.setId(id);
                    entry.setJour_id(Jou_id);
                    entry.setTopic(topic);
                    entry.setText(text);
                    entry.setPath(path);
                    entry.setDate(date);

                    db.insert_entry(entry);
                    Toast errorToast = Toast.makeText(create_entry.this, "Successfully Created", Toast.LENGTH_SHORT);
                    errorToast.show();
                }
                else
                {
                    Toast errorToast = Toast.makeText(create_entry.this, "Error, incorrect journal id!", Toast.LENGTH_SHORT);
                    errorToast.show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode)
        {
            case 10:

                if(resultCode==RESULT_OK)
                {
                    p = data.getData().getPath();
                    cre_ent_tv4.setText(p);
                }
                break;
        }
    }
}
