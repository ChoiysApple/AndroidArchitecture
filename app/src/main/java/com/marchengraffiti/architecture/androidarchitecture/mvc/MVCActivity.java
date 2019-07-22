package com.marchengraffiti.architecture.androidarchitecture.mvc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.marchengraffiti.architecture.androidarchitecture.R;

import java.util.ArrayList;
import java.util.List;

public class MVCActivity extends AppCompatActivity {

    private List<String> listValues = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        setTitle("MVC Activity");

        list = findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, listValues);

        //on click listener
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MVCActivity.this, "You Clicked" + listValues.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<String> vals = new ArrayList<>();

        for(int i = 0 ;i<3;i++) {
            vals.add("UK");
            vals.add("USA");
            vals.add("France");
            vals.add("Italy");
            vals.add("China");
            vals.add("Japan");
        }


        setValues(vals);
    }

    //method gives us values
    public void setValues(List<String> values){
        listValues.clear();
        listValues.addAll(values);      //addAll: add all data from arraylist
        adapter.notifyDataSetChanged(); //telling the adapter there are new value
    }

    public static Intent getIntent(Context context){
        return new Intent(context, MVCActivity.class);
    }
}
