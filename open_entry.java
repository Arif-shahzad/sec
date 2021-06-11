package com.example.projectsec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class open_entry extends AppCompatActivity {

    Button b1, b2;
    TextView tv;
    EditText et;

    database db;

    List<entry_model> li = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_entry);

        b1 = (Button) findViewById(R.id.open_entry_b1);
        b2 = (Button) findViewById(R.id.open_entry_b2);

        tv = (TextView) findViewById(R.id.open_entry_tv1);

        et = (EditText) findViewById(R.id.open_entry_et1);

        db = new database(this);
        db.open_db();

        li = db.get_entries();

        Intent i = getIntent();
        final String jid = i.getStringExtra("msg1");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_entry_list_display(jid);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int z;
                String id = et.getText().toString();
                for(z = 0 ; z<li.size() ; z++)
                {
                    if(li.get(z).getJour_id().equalsIgnoreCase(jid) && li.get(z).getId().equalsIgnoreCase(id))
                        break;
                }
                if(z<li.size())
                    call_entry_display(li.get(z).getId(), li.get(z).getJour_id(), li.get(z).getTopic(), li.get(z).getText(), li.get(z).getPath(), li.get(z).getDate());
                else
                {
                    Toast errorToast = Toast.makeText(open_entry.this, "ERROR: invalid id!", Toast.LENGTH_SHORT);
                    errorToast.show();
                }

            }
        });
    }

    public void call_entry_list_display(String jid)
    {
        Intent ii = new Intent(this ,entry_list_display.class);
        ii.putExtra("msg1", jid);
        startActivity(ii);
    }

    public void call_entry_display(String id, String jid, String topic, String text, String path, String date)
    {
        Intent ii = new Intent(this, entry_display.class);
        ii.putExtra("msg1", id);
        ii.putExtra("msg2", jid);
        ii.putExtra("msg3", topic);
        ii.putExtra("msg4", text);
        ii.putExtra("msg5", path);
        ii.putExtra("msg6", date);
        startActivity(ii);
    }
}
