package com.example.jendelapelajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MateriIPA extends AppCompatActivity {
    ArrayList<Data_ipa> list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_ipa);

        getSupportActionBar().setTitle("SOAL IPA");
        data();
        listView = findViewById(R.id.listview);
        Adapter_IPA adapter = new Adapter_IPA(getApplicationContext(), list);
        listView.setAdapter(adapter);
    }


    void data() {
        list = new ArrayList<>();
        list.add(new Data_ipa("Kelas-4"));
        list.add(new Data_ipa("Kelas-5"));
        list.add(new Data_ipa("Kelas-6"));
    }

}


class Data_ipa {
    String materi_ipa = "";
    Data_ipa(String materi_ipa){
        this.materi_ipa = materi_ipa;
    }

    public String getMateri_ipa() {
        return materi_ipa;
    }
}

class Adapter_IPA extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    ArrayList<Data_ipa> model;

    Adapter_IPA(Context context, ArrayList<Data_ipa> model)
    {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int index) {
        return model.get(index);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    TextView materi;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = layoutInflater.inflate(R.layout.list_item_ipa, viewGroup, false);
        materi = view1.findViewById(R.id.materi);

        materi.setText(model.get(i).getMateri_ipa());
        return view1;
    }

}