package com.example.sam.bestday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class KategoriActivity extends AppCompatActivity {

    ListView kategoriListesi;
    EditText kategoriAdi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        kategoriListesi= (ListView) findViewById(R.id.lvKategoriListesi);
        kategoriAdi= (EditText)findViewById(R.id.etKategoriAdi);
        kategoriListesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tiklanilanKategori = (String) kategoriListesi.getItemAtPosition(position);
                kategoriAdi.setText(tiklanilanKategori);
            }
        });
    }
  //geri oku çalıştırmak için kullandık önceki sayfaya geri dönmek için 12,13 satırlar dahil
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
