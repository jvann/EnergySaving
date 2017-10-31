package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jibril on 10/30/17.
 */

public class ElectroDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ElectrosDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DEBUG_TAG = "ELECTRO_DB_HELPER";

    public ElectroDBHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        String CREATE_ELECTROS_TABLE = "CREATE TABLE " +
                DataBaseSchema.ElectrosTable.TABLE_NAME +
                "(" +
                DataBaseSchema.ElectrosTable._ID + " INTEGER PRIMARY KEY, " +
                DataBaseSchema.ElectrosTable.COLUMN_NAME + " TEXT," +
                DataBaseSchema.ElectrosTable.COLUMN_WATTS + " INTEGER,"+
                DataBaseSchema.ElectrosTable.COLUMN_IMAGE + " BLOB " +
                ")";

        Log.d(DEBUG_TAG, CREATE_ELECTROS_TABLE);
        db.execSQL(CREATE_ELECTROS_TABLE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        String DELETE_ELECTROS_TABLE = "DROP TABLE IF EXISTS " +
                DataBaseSchema.ElectrosTable.TABLE_NAME;

        Log.d(DEBUG_TAG, DELETE_ELECTROS_TABLE);
        db.execSQL(DELETE_ELECTROS_TABLE);
        onCreate(db);
    }

    public void onDowngrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
