package com.example.abhiw.latihanrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMahasiswa;
    private ArrayList<Mahasiswa> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("List Mahasiswa");

        rvMahasiswa = findViewById(R.id.rv_data);
        rvMahasiswa.setHasFixedSize(true);

        list.addAll(DataMahasiswa.getListData());
        showRecyclerList();



    }
    private void showRecyclerList()
    {
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(this));
        ListMahasiswaAdapter listMahasiswaAdapter = new ListMahasiswaAdapter(list);
        rvMahasiswa.setAdapter(listMahasiswaAdapter);

//        listMahasiswaAdapter.setOnItemClickCallback(new ListMahasiswaAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(Mahasiswa data) {
//                showSelectedMahasiswa(data);
//                Intent ii = new Intent(getApplicationContext(),DetailActivity.class);
//                Bundle extras = new Bundle();
//                extras.putString("nama",data.getName());
//                extras.putString("univ",data.getUniv());
//                extras.putString("gender",data.getGender());
//                extras.putString("jurusan",data.getJurusan());
//                extras.putInt("foto",data.getPhoto());
//                ii.putExtras(extras);
////                    Intent intent = DetailActivity.newIntent(getApplicationContext(),data);
//                getApplicationContext().startActivity(ii);
//            }
//        });
    }
    private void showSelectedMahasiswa(Mahasiswa mahasiswa)
    {
        Toast.makeText(this,"Anda mengklik "+mahasiswa.getName(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profil,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.about){
            Toast.makeText(this,"Anda mengklik About",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,AboutActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
