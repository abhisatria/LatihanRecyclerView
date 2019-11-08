package com.example.abhiw.latihanrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListMahasiswaAdapter extends RecyclerView.Adapter<ListMahasiswaAdapter.ListViewHolder> {
    private ArrayList<Mahasiswa> listMahasiswa;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private OnItemClickCallback onItemClickCallback;

    public ListMahasiswaAdapter(ArrayList<Mahasiswa> list)
    {
        this.listMahasiswa = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_data,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder listViewHolder, int i) {

        Mahasiswa mahasiswa = listMahasiswa.get(i);
//        listViewHolder.imgPhoto.setImageResource(mahasiswa.getPhoto());
        Glide.with(listViewHolder.itemView.getContext())
                .load(mahasiswa.getPhoto()).into(listViewHolder.imgPhoto);
        listViewHolder.tvName.setText(mahasiswa.getName());
        listViewHolder.tvUniv.setText(mahasiswa.getUniv());

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(listViewHolder.itemView.getContext(),"baru",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(),DetailActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nama",listMahasiswa.get(listViewHolder.getAdapterPosition()).getName());
                extras.putString("univ",listMahasiswa.get(listViewHolder.getAdapterPosition()).getUniv());
                extras.putString("gender",listMahasiswa.get(listViewHolder.getAdapterPosition()).getGender());
                extras.putString("jurusan",listMahasiswa.get(listViewHolder.getAdapterPosition()).getJurusan());
                extras.putInt("foto",listMahasiswa.get(listViewHolder.getAdapterPosition()).getPhoto());
                intent.putExtras(extras);
                listViewHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMahasiswa.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName,tvUniv;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_nama);
            tvUniv = itemView.findViewById(R.id.tv_univ);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Mahasiswa data);
    }
}
