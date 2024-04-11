package vn.hcmute.lab7.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import vn.hcmute.lab7.DatabaseHandler;
import vn.hcmute.lab7.R;
import vn.hcmute.lab7.adapters.NotesAdapter;
import vn.hcmute.lab7.models.NotesModel;

public class SQLiteActivity extends AppCompatActivity {

    DatabaseHandler dbHandler;
    ListView listView;
    ArrayList<NotesModel> listNotes;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        listView = findViewById(R.id.lvData);
        listNotes = new ArrayList<>();
        InitDatabaseSQLite();
        adapter = new NotesAdapter(this, R.layout.row_notes, listNotes);
        databaseSQLite();
        listView.setAdapter(adapter);
    }
    private void InitDatabaseSQLite() {
        dbHandler = new DatabaseHandler(this, "dbNotes.sqlite", null, 1);
        dbHandler.QueryData("CREATE TABLE IF NOT EXISTS Notes(Id INTEGER PRIMARY KEY AUTOINCREMENT, Content VARCHAR(200))");
        this.createDatabaseSqlite();
    }

    private void databaseSQLite() {
        Cursor cursor = dbHandler.GetData("SELECT * FROM Notes");
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String content = cursor.getString(1);
            Log.d("SQLite", id + " - " + content);
            listNotes.add(new NotesModel(id, content));
        }
        adapter.notifyDataSetChanged();
    }

    private void createDatabaseSqlite() {
        dbHandler.QueryData("INSERT INTO Notes VALUES(null, 'Hello World')");
        dbHandler.QueryData("INSERT INTO Notes VALUES(null, 'Test notes 1')");
        dbHandler.QueryData("INSERT INTO Notes VALUES(null, 'Test notes 2')");
        dbHandler.QueryData("INSERT INTO Notes VALUES(null, 'Test notes 3')");
        dbHandler.QueryData("INSERT INTO Notes VALUES(null, 'Test notes 4')");
        dbHandler.QueryData("INSERT INTO Notes VALUES(null, 'Test notes 5')");
    }
}