package com.example.sam.bestday;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.sam.bestday.data.BestDayContract;
import com.example.sam.bestday.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {


    Spinner spinner;
    ListView notlarListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        notOlustur();

       // DatabaseHelper helper = new DatabaseHelper(this);
        //SQLiteDatabase db =helper.getReadableDatabase();


        spinner=(Spinner) findViewById(R.id.spinner);
        notlarListesi =(ListView)findViewById(R.id.lvnotlar);

        String[] notlar = getResources().getStringArray(R.array.Notlar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.notlar_tek_satir,R.id.tvNot,notlar);
        notlarListesi.setAdapter(adapter);

        notlarListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,NotActivity.class);
                String tiklanilanNot= (String) notlarListesi.getItemAtPosition(position);
                intent.putExtra("notIcerik",tiklanilanNot);
                startActivity(intent);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NotActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_kategori) {
            Intent intent = new Intent(this,KategoriActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void notOlustur(){
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        String insertSorgusu ="INSERT INTO notlar ("
                   + BestDayContract.NotlarEntry.COLUMN_NOT_ICERIK + ","
                   + BestDayContract.NotlarEntry.COLUMN_KATEGORI_ID + ","
                   + BestDayContract.NotlarEntry.COLUMN_OLUSTURULMA_TARIHI + ","
                   + BestDayContract.NotlarEntry.COLUMN_BITIS_TARIHI + ","
                   + BestDayContract.NotlarEntry.COLUMN_YAPILDI + ")"
                   + "VALUES(\"SPORA GIT\",1,\"07-05-2017\", \"\",0)";

        db.execSQL(insertSorgusu);

        ContentValues yeniKayit = new ContentValues();
        yeniKayit.put(BestDayContract.NotlarEntry.COLUMN_NOT_ICERIK,"Okula Uğra");
        yeniKayit.put(BestDayContract.NotlarEntry.COLUMN_KATEGORI_ID,1);
        yeniKayit.put(BestDayContract.NotlarEntry.COLUMN_OLUSTURULMA_TARIHI,"06-05-2017");
        yeniKayit.put(BestDayContract.NotlarEntry.COLUMN_YAPILDI,0);

        long id = db.insert(BestDayContract.NotlarEntry.TABLE_NAME,null,yeniKayit);


    }
}
