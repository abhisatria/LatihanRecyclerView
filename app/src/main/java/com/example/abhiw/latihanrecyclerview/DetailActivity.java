package com.example.abhiw.latihanrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    ImageView imgMahasiswa;
    TextView tvNama,tvUniv,tvJurusan,tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle(getIntent().getStringExtra("nama"));
        imgMahasiswa = findViewById(R.id.fotoM);
        tvNama = findViewById(R.id.namaM);
        tvUniv=findViewById(R.id.kampusM);
        tvJurusan=findViewById(R.id.jurusanM);
        tvGender=findViewById(R.id.genderM);

        Glide.with(this).load(getIntent().getIntExtra("foto",0)).apply(new RequestOptions().override(150,150)).into(imgMahasiswa);
        tvNama.setText(getIntent().getStringExtra("nama"));
        tvUniv.setText(getIntent().getStringExtra("univ"));
        tvJurusan.setText(getIntent().getStringExtra("jurusan"));
        tvGender.setText(getIntent().getStringExtra("gender"));
    }
    public static Intent newIntent(Context context, Mahasiswa data)
    {
        Intent intent = new Intent(context,DetailActivity.class);

        Bundle extras = new Bundle();
        extras.putString("nama",data.getName());
        extras.putString("univ",data.getUniv());
        extras.putString("gender",data.getGender());
        extras.putString("jurusan",data.getJurusan());
        extras.putInt("foto",data.getPhoto());

        intent.putExtras(extras);
        return intent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
