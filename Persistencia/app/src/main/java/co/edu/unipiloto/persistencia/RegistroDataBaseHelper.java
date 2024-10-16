package co.edu.unipiloto.persistencia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegistroDataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "REGISTROS";
    public static final int DB_VERSION = 1;

    public RegistroDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE REGISTROS("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "DIRECCION_O TEXT,"
                + "TIPO_CARGA TEXT,"
                + "ALTO TEXT,"
                + "ANCHO TEXT,"
                + "PESO TEXT,"
                + "HORA TEXT,"
                + "FECHA TEXT);");
    }

    public boolean isDuplicate(SQLiteDatabase db, String dir, String tipo, String alto, String ancho, String peso, String hora, String fecha) {
        String query = "SELECT * FROM REGISTROS WHERE DIRECCION_O = ? AND TIPO_CARGA = ? AND ALTO = ? AND ANCHO = ? AND PESO = ? AND HORA = ? AND FECHA = ?";
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query, new String[]{dir, tipo, alto, ancho, peso, hora, fecha});
            return (cursor != null && cursor.getCount() > 0);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}