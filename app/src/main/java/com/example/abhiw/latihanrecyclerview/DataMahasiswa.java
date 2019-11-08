package com.example.abhiw.latihanrecyclerview;

import java.util.ArrayList;

public class DataMahasiswa {
    //nama jurusan nim gender foto
    public static String[][] data = new String[][]{
            {"Abhi Satria Wisesa","Mobile Application & Technology","Universitas Bina Nusantara","Male", String.valueOf(R.drawable.abhi)},
            {"Pasek Wedaswara","Pendidikan Dokter Gigi","Universitas Mahasaraswati","Male", String.valueOf(R.drawable.pasek)},
            {"Dony Setiawan","Akuntansi","Universitas Pendidikan Ganesha","Male", String.valueOf(R.drawable.dony)},
            {"Ajib Alamsyah","Pendidikan Dokter","Universitas Udayana","Male", String.valueOf(R.drawable.ajib)},
            {"Ananta Widjaksana","Pendidikan Dokter","Universitas Warmadewa","Male", String.valueOf(R.drawable.aan)},
            {"Angga Pujawan","Teknik Sipil","Universitas Warmadewa","Male", String.valueOf(R.drawable.angga)},
            {"Enrico Pramana","Pendidikan Dokter","Universitas Pendidikan Ganesha","Male", String.valueOf(R.drawable.enrico)},
            {"Ketut Yoga Wira","Pendidikan Dokter","Universitas Udayana","Male", String.valueOf(R.drawable.yoga)},
            {"Mahayogi Harta","Ilmu Komputer","Universitas Pendidikan Ganesha","Male", String.valueOf(R.drawable.mahayogi)},
            {"Pramudya Putra","D1 Bea Cukai","Sekolah Tinggi Akuntansi Negara","Male", String.valueOf(R.drawable.pramu)},
            {"Christopher Teddy","Mobile Application & Technology","Universitas Bina Nusantara","Male", String.valueOf(R.drawable.teddy)},
            {"Natalia Fellyana","Mobile Application & Technology","Universitas Bina Nusantara","Female", String.valueOf(R.drawable.natalia)},
            {"Kendra Arsena","Mobile Application & Technology","Universitas Bina Nusantara","Male", String.valueOf(R.drawable.kendra)},
            {"Dinda Oktavianty","Teknik Industri","Institut Teknologi Nasional","Female", String.valueOf(R.drawable.dinda)},
    };

    public static ArrayList<Mahasiswa> getListData(){
        ArrayList<Mahasiswa> list = new ArrayList<>();
        for(String[] aData : data){
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setName(aData[0]);
            mahasiswa.setUniv(aData[2]);
            mahasiswa.setJurusan(aData[1]);
            mahasiswa.setGender(aData[3]);
            mahasiswa.setPhoto(Integer.valueOf(aData[4]));

            list.add(mahasiswa);
        }
        return list;
    }
}
