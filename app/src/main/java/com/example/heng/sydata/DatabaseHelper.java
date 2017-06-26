package com.example.heng.sydata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by heng on 2017/6/25.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String COST_MONEY = "cost_money";
    public static final String COST_DATA = "cost_data";
    public static final String COST_TITLE = "cost_title";
    public static final String HENG_COST = "heng_cost";

    public DatabaseHelper(Context context) {
        super(context, "heng_cost", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists "+HENG_COST+"(" +
                "id integer primary key," +
                "cost_title varchar," +
                "cost_data varchar," +
                COST_MONEY+" varchar)");
    }
    public void insertCost(CostBean costBean){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COST_TITLE,costBean.costTitle);
        cv.put(COST_DATA,costBean.costDate);
        cv.put(COST_MONEY,costBean.costMoney);
        database.insert(HENG_COST,null,cv);
    }
    public Cursor getALLCostData(){
        SQLiteDatabase database = getWritableDatabase();
        return database.query(HENG_COST,null,null,null,null,null,"" + COST_DATA +" ASC");
    }
    public void deleteALLData(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(HENG_COST,null,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
