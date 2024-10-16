package co.edu.unipiloto.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private SQLiteDatabase db2;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void solicitar(View view) {

        try {
            cursor = db2.query("REGISTROS",
                    new String[]{"_id, DIRECCION_O"}, null, null, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(MainActivity2.this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{"DIRECCION_O"},
                    new int[]{android.R.id.text1},
                    0);


        } catch (SQLException e) {
            Toast toast = Toast.makeText(this, "epa, como que no funciono mani...", Toast.LENGTH_SHORT);
            toast.show();
        }
    }



    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db2.close();
    }
}