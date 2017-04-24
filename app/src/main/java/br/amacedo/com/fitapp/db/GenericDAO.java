package br.amacedo.com.fitapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Anderson Macedo on 24/04/2017.
 */

public class GenericDAO
{
    private DBHelper dbhelper;
    private SQLiteDatabase db;

    public GenericDAO(Context context)
    {
        dbhelper = new DBHelper(context);
    }

    public SQLiteDatabase getDB()
    {
        if(db == null)
        {
            db = dbhelper.getWritableDatabase();
        }
        return db;
    }
}
