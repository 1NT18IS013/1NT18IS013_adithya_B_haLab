package com.example.sqliteform;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int version = 1;
    public  static String dbName="Orders.db";
    public static final String TABLE_NAME ="Orders";
    public static final String COL1 = "id";
    public static final String COL2 = "phno";
    public static final String COL3 = "orderItems";
    public static final String COL4 = "address";

    private static final String CREATE_TABLE="create table if not exists "+ TABLE_NAME + "(" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+COL2+" TEXT NOT NULL," + COL3 + " TEXT NOT NULL, " +COL4 + " TEXT NOT NULL);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
    private static final String SELECT_QUERY ="select * from "+ TABLE_NAME+ " where "+ COL2 +" = ?";
    private Context context;
    public DatabaseHelper(Context context) {
        super(context,dbName,null,version);
        context=this.context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {}
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean InsertOrder(Order objOrd) {
        SQLiteDatabase dbn = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL2,objOrd.getUserPhNo());
        cv.put(COL3,objOrd.getUserOrder());
        cv.put(COL4,objOrd.getUserAdd());

        long result = dbn.insert(TABLE_NAME, null, cv);
        if(result == -1)
            return  false;
        else
            return true;
    }

    public boolean UpdateOrder(Order objOrd){
        SQLiteDatabase dbn = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL3,objOrd.getUserOrder());
        cv.put(COL4,objOrd.getUserAdd());
        Cursor cursor = dbn.rawQuery(SELECT_QUERY, new String[] {objOrd.getUserPhNo()});

        if(cursor.getCount() > 0){
            long result = dbn.update(TABLE_NAME, cv, COL2+"=?", new String[] {objOrd.getUserPhNo()});
            if(result == -1)
                return false;
            else
                return true;
        }else  {
            return false;
        }
    }

    public boolean DeleteOrder(Order objOrd){
        SQLiteDatabase dbn = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        Cursor cursor = dbn.rawQuery(SELECT_QUERY, new String[] {objOrd.getUserPhNo()});
        if(cursor.getCount() > 0){
            long result = dbn.delete(TABLE_NAME, COL2+"=?", new String[] {objOrd.getUserPhNo()});
            if(result == -1)
                return false;
            else
                return true;
        }else  {
            return false;
        }
    }

    public Cursor viewData(){
        SQLiteDatabase dbn = this.getWritableDatabase();
        Cursor cursor = dbn.rawQuery("Select * from "+TABLE_NAME, null);
        return cursor;
    }
}
