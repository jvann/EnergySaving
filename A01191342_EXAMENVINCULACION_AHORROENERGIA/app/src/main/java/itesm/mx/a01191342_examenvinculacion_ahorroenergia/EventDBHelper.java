package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jibril on 10/30/17.
 */

public class EventDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "EventssDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DEBUG_TAG = "EVENT_DB_HELPER";

    public EventDBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        String CREATE_EVENTS_TABLE = "CREATE TABLE " +
                DataBaseSchema.EventsTable.TABLE_NAME +
                "(" +
                DataBaseSchema.EventsTable._ID + " INTEGER PRIMARY KEY, " +
                DataBaseSchema.EventsTable.COLUMN_DATE + " TEXT," +//Comes from timestamp, needs to be converted at the moment of inserting.
                DataBaseSchema.EventsTable.COLUMN_TYPE + " TEXT," +
                DataBaseSchema.EventsTable.COLUMN_IMAGE + " BLOB," +
                DataBaseSchema.EventsTable.COLUMN_USE + " INTEGER " +
                ")";

        Log.d(DEBUG_TAG, CREATE_EVENTS_TABLE);
        db.execSQL(CREATE_EVENTS_TABLE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        String DELETE_EVENTS_TABLE = "DROP TABLE IF EXISTS " +
                DataBaseSchema.EventsTable.TABLE_NAME;

        Log.d(DEBUG_TAG, DELETE_EVENTS_TABLE);
        db.execSQL(DELETE_EVENTS_TABLE);
        onCreate(db);
    }

    public void onDowngrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}