package itesm.mx.a01191342_examenvinculacion_ahorroenergia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Jibril on 10/30/17.
 */

public class ElectroOperations {

    private SQLiteDatabase db;
    private ElectroDBHelper dbHelper;
    private Electro electro;

    public ElectroOperations (Context context) {
        dbHelper = new ElectroDBHelper(context);
    }

    public void open() throws SQLException {
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException e) {
            Log.e("SQLOPEN", e.toString());
        }
    }

    public void close() {
        db.close();
    }

    public long addElectro(Electro electro) {
        long newRowId = 0;

        try {
            ContentValues values = new ContentValues();
            values.put(DataBaseSchema.ElectrosTable.COLUMN_NAME, electro.getNameE());
            values.put(DataBaseSchema.ElectrosTable.COLUMN_WATTS, electro.getWatts());
            values.put(DataBaseSchema.ElectrosTable.COLUMN_IMAGE, electro.getPicture());

            newRowId = db.insert(DataBaseSchema.ElectrosTable.TABLE_NAME, null, values);
        } catch (SQLException e) {
            Log.e("SQLADD", e.toString());
        }

        return newRowId;

    }

    public Electro findElectro(String electroName) {

        String query = "Select * FROM " +
                DataBaseSchema.ElectrosTable.TABLE_NAME +
                " WHERE " + DataBaseSchema.ElectrosTable.COLUMN_NAME +
                " = \"" + electroName + "\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            electro = null;
            if (cursor.moveToFirst()) {
                electro = new Electro(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        Integer.parseInt(cursor.getString(2)),
                        cursor.getBlob(3)
                );
            }
            cursor.close();

        }catch (SQLException e) {
            Log.e("SQLFIND", e.toString());
        }

        return electro;
    }

    public boolean deleteElectro(String electroName) {

        boolean result = false;

        String query = "SELECT * FROM " + DataBaseSchema.ElectrosTable.TABLE_NAME +
                " WHERE " + DataBaseSchema.ElectrosTable.COLUMN_NAME +
                " = \"" + electroName + "\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                int id = Integer.parseInt((cursor.getString(0)));
                db.delete(DataBaseSchema.ElectrosTable.TABLE_NAME,
                        DataBaseSchema.ElectrosTable._ID + " = ?",
                        new String[]{String.valueOf(id)});
                result = true;
            }
            cursor.close();
        } catch (SQLException e) {
            Log.e("SQLDELETE", e.toString());
        }

        return result;
    }

    public ArrayList<Electro> getAllElectros() {
        ArrayList<Electro> listaElectros = new ArrayList<Electro>();

        String selectQuery = "SELECT * FROM " + DataBaseSchema.ElectrosTable.TABLE_NAME;

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    electro = new Electro(
                            Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            Integer.parseInt(cursor.getString(2)),
                            cursor.getBlob(3)
                    );

                    listaElectros.add(electro);
                } while (cursor.moveToNext());
            }
            cursor.close();

        } catch (SQLException e) {
            Log.e("SQLLIST", e.toString());
        }
        return listaElectros;
    }
}
