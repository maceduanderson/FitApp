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

    /**
     * Instantiates a new Generic dao.
     *
     * @param context the context
     */
    public GenericDAO(Context context)
    {
        dbhelper = new DBHelper(context);
    }

    /**
     * Gets db.
     *
     * @return the db
     */
    public SQLiteDatabase getDB()
    {
        if(db == null)
        {
            db = dbhelper.getWritableDatabase();
        }
        return db;
    }
}
