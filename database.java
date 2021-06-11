package com.example.projectsec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper
{

    private static final int VERSION = 1;

    private static final String NAME = "MYDIARY", JOURNAL_TABLE = "journal", ENTRY_TABLE = "entry";

    private static final String J_ID = "id", J_NAME = "name", J_PASSWORD = "password";

    private static final String E_ID = "id", E_JOU_ID = "journal_id",E_TOPIC = "topic", E_TEXT = "text", E_PATH = "path", E_DATE = "date";

    private static final String CREATE_JOURNAL_TABLE = "CREATE TABLE " + JOURNAL_TABLE + "(" + J_ID + " TEXT PRIMARY KEY, "
                                                        + J_NAME + " TEXT, " + J_PASSWORD + " INTEGER)";

    private static final String CREATE_ENTRY_TABLE = "CREATE TABLE " + ENTRY_TABLE + "(" + E_ID + " TEXT PRIMARY KEY, "
                                                     + E_JOU_ID +" TEXT, " + E_TOPIC + " TEXT, " + E_TEXT + " TEXT, " + E_PATH + " TEXT, "
                                                     + E_DATE + " TEXT)";

    private SQLiteDatabase db;

    public database(Context context)
    {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_JOURNAL_TABLE);
        db.execSQL(CREATE_ENTRY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + JOURNAL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ENTRY_TABLE);
        onCreate(db);
    }

    public void open_db()
    {
        db = this.getWritableDatabase();
    }

    public void insert_journal(journal_model jou)
    {
        ContentValues cv = new ContentValues();
        cv.put(J_ID, jou.getId());
        cv.put(J_NAME, jou.getName());
        cv.put(J_PASSWORD, jou.getPassword());
        db.insert(JOURNAL_TABLE, null, cv);
    }

    public void insert_entry(entry_model ent)
    {
        ContentValues cv = new ContentValues();
        cv.put(E_ID, ent.getId());
        cv.put(E_JOU_ID, ent.getJour_id());
        cv.put(E_TOPIC, ent.getTopic());
        cv.put(E_TEXT, ent.getText());
        cv.put(E_PATH, ent.getPath());
        cv.put(E_DATE, ent.getDate());
        db.insert(ENTRY_TABLE, null, cv);
    }

    public List<journal_model> get_journals()
    {
        List<journal_model> journal_list = new ArrayList<>();
        Cursor cur = null;
        db.beginTransaction();
        try
        {
            cur = db.query(JOURNAL_TABLE, null, null, null, null, null, null, null);
            if(cur != null)
            {
                if(cur.moveToFirst())
                {
                    do{
                        journal_model journal = new journal_model();
                        journal.setId(cur.getString(cur.getColumnIndex(J_ID)));
                        journal.setName(cur.getString(cur.getColumnIndex(J_NAME)));
                        journal.setPassword(cur.getInt(cur.getColumnIndex(J_PASSWORD)));
                        journal_list.add(journal);
                    }while(cur.moveToNext());
                }
            }
        }
        finally
        {
            db.endTransaction();
            assert cur != null;
            cur.close();
        }
        return journal_list;
    }

    public List<entry_model> get_entries()
    {
        List<entry_model> entry_list = new ArrayList<>();
        Cursor cur = null;
        db.beginTransaction();
        try
        {
            cur = db.query(ENTRY_TABLE, null, null, null, null, null, null, null);
            if(cur != null)
            {
                if(cur.moveToFirst())
                {
                    do{
                        entry_model entry = new entry_model();
                        entry.setId(cur.getString(cur.getColumnIndex(E_ID)));
                        entry.setJour_id(cur.getString(cur.getColumnIndex(E_JOU_ID)));
                        entry.setTopic(cur.getString(cur.getColumnIndex(E_TOPIC)));
                        entry.setText(cur.getString(cur.getColumnIndex(E_TEXT)));
                        entry.setPath(cur.getString(cur.getColumnIndex(E_PATH)));
                        entry.setDate(cur.getString(cur.getColumnIndex(E_DATE)));
                        entry_list.add(entry);
                    }while(cur.moveToNext());
                }
            }
        }
        finally
        {
            db.endTransaction();
            assert cur != null;
            cur.close();
        }
        return entry_list;
    }
}